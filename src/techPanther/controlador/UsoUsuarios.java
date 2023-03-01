package techPanther.controlador;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import techPanther.modelo.*;
import techPanther.vista.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Control de las comunicaciones entre la Capa Vista y la Capa Modelo, se encarga de procesar
//las peticiones de los botones que se activen en la vista y devolver una respuesta de la BBDD.
public class UsoUsuarios {

    public UsoUsuarios() {

        usuarioDao = new UsuarioDAO();
    }

    //Método encargado de procesar los campos de usuario y password provenientes de la capa Vista y enviarlos a la Capa Datos,
    //de ser válidas las credenciales, devolverá un campo con el tipo de permiso del usuario para cargar la ventana adecuada.
    public String iniciarSesion(String user, String pass) {

        if (!user.equals("") && !pass.equals("")) {

            Usuario u = usuarioDao.selectByUserPass(user, pass);

            String tipo_permiso = u.getTipo_nivel();

            return tipo_permiso;

        } else {

            JOptionPane.showMessageDialog(null, "No puede dejar campos vacios, porfavor intente nuevamente.");
            return "";
        }
    }

    //Método encargado de procesar los campos de usuario provenientes de la Capa Vista y enviarlos a la Capa Datos
    //para agregarlos a la BBBD como un nuevo registro.
    public boolean agregarUsuario(String nombre, String email, String telefono, String domicilio,
            String usuario, String pass, String permisos, String registrado_por) {

        if (!nombre.equals("") && !usuario.equals("") && !pass.equals("") && !permisos.equals("")) {

            Usuario u = new Usuario(nombre, usuario, pass, domicilio, permisos, telefono, email, registrado_por);

            usuarioDao.agregarUsuario(u);

            return true;
        } else {

            JOptionPane.showMessageDialog(null, "¡No se ha podido agregar el usuario¡ \n !No debe dejar en blanco los campos obligatorios(marcados con el '*')!");
            return false;
        }

    }

    public void actualizarUsuario(int id_usuario,String nombre, String email, String telefono, String domicilio,
            String usuario, String permisos, String registrado_por) {

        if (!nombre.equals("") && !usuario.equals("")) {

            Usuario u = new Usuario(id_usuario,nombre, usuario, domicilio, permisos, telefono, email, registrado_por);

            usuarioDao.updateUsuario(u);
            
            

        } else {
            
            JOptionPane.showMessageDialog(null, "!No debe dejar en blanco los campos obligatorios(marcados con el '*')!");
        }

    }

    //Método encargado de obtener el nombre completo de un usuario según el parámetro de username.
    public String mensajeBienvenida(String user) {

        if (!user.equals("") && !user.equals(null)) {

            Usuario u = usuarioDao.selectByUser(user);

            String nombre = u.getNombre();

            return nombre;
        } else {

            JOptionPane.showMessageDialog(null, "Ha habido un problema para obtener el nombre del usuario desde la BBDD.");
            return null;
        }
    }

    //Método para seleccionar todos los campos de Usuario de la BBDD y regresarlo como una tabla lista.
    public JTable listarUsuarios() {

        List<Usuario> lista = new ArrayList();

        lista = usuarioDao.selectUsuarios();

        DefaultTableModel modelo = new DefaultTableModel();

        JTable tabla = new JTable(modelo);

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Usuario");
        modelo.addColumn("Correo");
        modelo.addColumn("Permisos");

        for (Usuario usuario : lista) {

            Object[] user = new Object[5];

            user[0] = usuario.getId_usuario();
            user[1] = usuario.getNombre();
            user[2] = usuario.getUsername();
            user[3] = usuario.getCorreo();
            user[4] = usuario.getTipo_nivel();

            modelo.addRow(user);
        }
        return tabla;
    }

    //Método para leer un Usuario desde la BBDD.
    public Object[] obtenerUsuario(int id_user) {

        Usuario u = usuarioDao.selectByID(id_user);

        Object[] lista = new Object[7];

        lista[0] = u.getNombre();
        lista[1] = u.getUsername();
        lista[2] = u.getCorreo();
        lista[3] = u.getTelefono();
        lista[4] = u.getRegistrado_por();
        lista[5] = u.getDomicilio();
        lista[6] = u.getTipo_nivel();

        return lista;
    }

    //Método para modificar la contraseña de un Usuario según su ID.
    public void actualizarPassword(String pass, int id_usuario) {

        usuarioDao.updatePasswordByID(pass, id_usuario);
    }
    
    
       public String importarTabla(JTable tabla, File archivo) {

        //CREAMOS UN WORKBOOK (PROVENIENTE DEL API DE POI)
        Workbook wb;
        //INICIALIZAMOS EL MODEO DE LA TABLA QUE VAMOS A LLENAR CON LOS DATOS DE EXCEL.
        DefaultTableModel modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        String respuesta = "";
        try {

            //INICIALIZAMOS EL WORKBOOK CREANDO UN ARCHIVO.
            wb = WorkbookFactory.create(archivo);
            //ACCEDEMOS A LA PRIMERA HOJA DEL ARCHIVO.
            Sheet hoja = wb.getSheetAt(0);
            //OBTENEMOS UN ITERADOR PARA LEER LAS FILAS DE ESE ARCHIVO
            Iterator iteradorFila = hoja.rowIterator();
            int contadorFila = -1;
            //LUEGO CON UN WHILE LEEMOS CADA FILA
            while (iteradorFila.hasNext()) {
                contadorFila++;
                //CREAMOS UN OBJETO FILA
                Row fila = (Row) iteradorFila.next();
                //CREAMOS UN ITERADOR AHORA PARA LAS COLUMNAS
                Iterator iteradorColumna = fila.cellIterator();
                //CREAMOS UN ARREGLO DE OBJETOS CON LA CANTIDAD DE POSICIONES QUE TENGA EN COLUMNAS LA TABLA A LEER
                Object[] datos = new Object[10];
                int indiceColumna = -1;
                //CON OTRO CICLO WHILE LEEMOS LAS COLUMNAS
                while (iteradorColumna.hasNext()) {
                    indiceColumna++;
                    //AHORA CON EL ACCESO A UNA COLUMNA DE UNA FILA ESPECIFICA LEEMOS LA CELDA
                    Cell celda = (Cell) iteradorColumna.next();
                    //DEPENDIENDO EL CASO, AÑADIMOS A LA TABLA EL NOMBRE DE CADA CAMPO SI ES LA PRIMERA FILA
                    if (contadorFila == 0) {

                        modelo.addColumn(celda.getStringCellValue());
                        //A PARTIR DE LA SEGUNDA FILA, DIFERENCIAMOS EL TIPO DE DATO Y LO AÑADIMOS AL ARREGLO DE OBJECT.
                    } else {

                        switch (celda.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:

                                datos[indiceColumna] = (int) Math.round(celda.getNumericCellValue());

                                break;

                            case Cell.CELL_TYPE_STRING:

                                datos[indiceColumna] = celda.getStringCellValue();
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:

                                datos[indiceColumna] = celda.getBooleanCellValue();
                                break;
                            default:

                                datos[indiceColumna] = celda.getDateCellValue();
                                break;
                        }
                    }
                    //AL FINALIZAR DE LEER LOS DATOS DE ESA FILA, VACIAMOS LOS DATOS DE ESA FILA EN LA TABLA, Y REPETIR EL PROCESO
                }
                if (contadorFila != 0) {
                    modelo.addRow(datos);
                }
            }

            respuesta = "¡Importación exitosa!";

            return respuesta;

        } catch (Exception e) {
            e.printStackTrace();
            respuesta = "No se ha podido realizar correctamente la importación";
            return respuesta;
        }

    }

    //MÉTODO PARA EXPORTAR COMO UNA TABLA DE EXCEL LOS DATOS DE LA TABLA 'EQUIPOS'
    public String exportarTabla(File archivo, JTable tabla) {

        //CREAMOS UN WORKBOOK (PROVENIENTE DEL API DE POI)
        Workbook wb;
        String respuesta = "";
        //OBTENEMOS LA CANTIDAD DE FILAS Y COLUMNAS DE LA TABLA A LEER.
        int numFila = tabla.getRowCount();
        int numColumnas = tabla.getColumnCount();
        //COMPROBAMOS SI EL ARCHIVO ES UN EXCEL ANTIGUO O MODERNO SEGÚN SU FORMATO.
        if (archivo.getName().endsWith("xls")) {

            wb = new HSSFWorkbook();
        } else {

            wb = new XSSFWorkbook();
        }
        Sheet hoja = wb.createSheet("Usuarios");
        try {
            //HACEMOS UN FOR PARA LEER CADA FILA 
            for (int i = -1; i < numFila; i++) {

                //CREAMOS LA FILA
                Row filas = hoja.createRow(i + 1);

                //HACEMOS UN FOR PARA LEER CADA COLUMNA DE CADA FILA.
                for (int j = 0; j < numColumnas; j++) {

                    //CREAMOS LA CELDA EN LA POSICIÓN DE LA COLUMNA ESPECIFICA
                    Cell celda = filas.createCell(j);

                    //DEPENDIENDO SI ES O NO LA PRIMERA FILA, SE COLOCA EL NOMBRE DEL CAPO O UN DATO.
                    if (i == -1) {

                        celda.setCellValue(String.valueOf(tabla.getColumnName(j)));
                    } else {

                        celda.setCellValue(String.valueOf(tabla.getValueAt(i, j)));
                    }
                    wb.write(new FileOutputStream(archivo));
                }
            }

            respuesta = "!Exportación exitosa!";

            return respuesta;

        } catch (Exception e) {

            e.printStackTrace();

            respuesta = "No se ha podido realizar correctamente la importación";

            return respuesta;

        }
    }
    

    private UsuarioDAO usuarioDao;
}
