package techPanther.controlador;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import techPanther.modelo.*;

public class UsoClientes {

    public UsoClientes() {

        clienteDao = new ClienteDAO();
    }

    //Método para agregar un cliete a la BBDD
    public boolean agregarCliente(String nombre, String correo, String telefono, String direccion, String ult_mod) {

        if (!nombre.equals("") && !telefono.equals("") && !correo.equals("") && !direccion.equals("")) {

            Cliente c = new Cliente(nombre, direccion, telefono, correo, ult_mod);

            clienteDao.agregarCliente(c);

            return true;

        } else {

            JOptionPane.showMessageDialog(null, "No puede dejar ningún campo en blanco, por favor verifique los datos.");

            return false;
        }

    }

    //Método para listar los clientes desde la BBDD, devolviendo una tabla lista para mostrar con los valores cargados.
    public JTable selectClientes() {

        List<Cliente> lista = clienteDao.selectClientes();

        DefaultTableModel model = new DefaultTableModel();

        JTable tabla = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Teléfono");
        model.addColumn("Correo");
        model.addColumn("Ultima Modificación");

        for (Cliente cliente : lista) {

            Object[] users = new Object[5];

            users[0] = cliente.getId_cliente();
            users[1] = cliente.getNombre();
            users[2] = cliente.getTelefono();
            users[3] = cliente.getCorreo();
            users[4] = cliente.getUltima_modificacion();

            model.addRow(users);
        }

        return tabla;
    }

    //Método para obtener un cliente desde la BBDD
    public Object[] obtenerCliente(int id_cliente) {

        Cliente c = clienteDao.selectbyID(id_cliente);

        Object[] lista = new Object[6];

        lista[0] = c.getId_cliente();
        lista[1] = c.getNombre();
        lista[2] = c.getDomicilio();
        lista[3] = c.getTelefono();
        lista[4] = c.getCorreo();
        lista[5] = c.getUltima_modificacion();

        return lista;

    }

    //Método para actualizar un cliente
    public void actualizarCliente(int id_cliente, String nombre, String domicilio, String telefono, String email, String ultiMod) {

        if (!nombre.equals("") && !domicilio.equals("") && !telefono.equals("") && !email.equals("")) {

            Cliente c = new Cliente(id_cliente, nombre, domicilio, telefono, email, ultiMod);

            if (clienteDao.updateCliente(c)) {

                JOptionPane.showMessageDialog(null, "¡Cliente actualizado correctamente!");
            }

        } else {

            JOptionPane.showMessageDialog(null, "No debe dejar campos en blanco, porfavor verifique los datos.");
        }

    }

    //Método para imprimir el listado de Clientes actuales en la BBDD.
    public void imprimir() {

        try {

            //SE TRABAJARÁ CON LAS LIBRERIAS DE ITEXTPDF.
            //SE CREA EL DOCUMENTO
            Document d = new Document();

            //SE ESPECIFICA LA RUTA DEL DISCO DURO Y EL USUARIO (C:/User)
            String ruta = System.getProperty("user.home");

            //SEGÚN ESA RUTA DE USUARIO, SE INDICA LA RUTA DEL ESCRITORIO Y INDICA DONDE SE ESCRIBRIÁ EL PDF, CON SU NOMBRE.
            PdfWriter.getInstance(d, new FileOutputStream(ruta + "/Desktop/ListaDeClientes.pdf"));

            //CREAMOS UNA IMAGEN PARA EL BANNER
            Image banner = Image.getInstance("src/images/banner.png");
            banner.scaleToFit(550, 1000);
            banner.setAlignment(Chunk.ALIGN_CENTER);

            //CREAMOS UN PARRAFO PARA EL TITULO DE LA TABLA
            Paragraph p = new Paragraph();
            p.setAlignment(Chunk.ALIGN_CENTER);
            p.setFont(FontFactory.getFont("Arial", 16, Font.BOLD));
            p.add("Listado de Clientes \n \n");

            //ABRIMOS EL DOCUMENTO Y AÑADIMOS EL BANNER Y EL TITULO ANTES CREADO.
            d.open();

            d.add(banner);
            d.add(p);

            //CREAMOS UNA TABLA PARA LOS DATOS DE LOS CLIENTES
            PdfPTable tabla = new PdfPTable(5);

            tabla.addCell("ID");
            tabla.addCell("Nombre");
            tabla.addCell("Domicilio");
            tabla.addCell("Teléfono");
            tabla.addCell("Correo");

            //LEEMOS LOS DATOS DE LOS CLIENTES LISTADOS, Y CON UN CICLO REPETITIVO LOS AÑADIMOS A LA TABLA
            List<Cliente> lista = clienteDao.selectClientes();

            if (!lista.isEmpty()) {

                for (Cliente cliente : lista) {

                    tabla.addCell(Integer.toString(cliente.getId_cliente()));
                    tabla.addCell(cliente.getNombre());
                    tabla.addCell(cliente.getDomicilio());
                    tabla.addCell(cliente.getTelefono());
                    tabla.addCell(cliente.getCorreo());

                }

                //AÑADIMOS LA TABLA AL FINAL DEL DOCUMENTO.
                d.add(tabla);

                JOptionPane.showMessageDialog(null, "¡Listado de Clientes generado en el escritorio!");

            } else {

                JOptionPane.showMessageDialog(null, "¡No se han encontrado clientes para listar en el documento!");

            }

            //CERRAMOS DOCUMENTO, IMPORTANTE!!!
            d.close();

        } catch (DocumentException | HeadlessException | IOException e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al listar datos y crear el reporte!");

        }

    }

    //Método para listar un cliente de la BBDD y los equipos registrados a su nombre.
    public void imprimirCliente(int id_cliente) {

        //SE TRABAJARÁ CON LAS LIBRERIAS DE ITEXTPDF.
        try {

            //SE CREA EL DOCUMENTO
            Document d = new Document();

            //SE ESPECIFICA LA RUTA DEL DISCO DURO Y EL USUARIO (C:/User)
            String ruta = System.getProperty("user.home");

            //SEGÚN ESA RUTA DE USUARIO, SE INDICA LA RUTA DEL ESCRITORIO Y INDICA DONDE SE ESCRIBRIÁ EL PDF, CON SU NOMBRE.
            PdfWriter.getInstance(d, new FileOutputStream(ruta + "/Desktop/DetallesDeCliente.pdf"));

            //CREAMOS UNA IMAGEN PARA EL BANNER
            Image banner = Image.getInstance("src/images/banner.png");
            banner.scaleToFit(550, 1000);
            banner.setAlignment(Chunk.ALIGN_CENTER);

            //CREAMOS UN PARRAFO PARA LA TABLA DEL CLIENTE
            Paragraph p_cliente = new Paragraph();
            p_cliente.setAlignment(Chunk.ALIGN_CENTER);
            p_cliente.setFont(FontFactory.getFont("Arial", 16, Font.BOLD));
            p_cliente.add("Detalles de Cliente \n \n");

            //ABRIMOS EL DOCUMENTO Y AÑADIMOS EL BANNER Y EL TITULO ANTES CREADO.
            d.open();
            d.add(banner);
            d.add(p_cliente);

            //CREAMOS UN OBJETO CLIENTE PARA RECIBIR LOS DATOS DEL CLIENTE EN CUESTIÓN
            Cliente c = clienteDao.selectbyID(id_cliente);

            EquipoDAO equipoDao = new EquipoDAO();

            //CREAMOS UNA LISTA DE EQUIPOS PARA RECIBIR EL LISTADO DE EQUIPOS DEL CLIENTE EN CUESTIÓN
            List<Equipo> equipos = equipoDao.selectEquiposByIdClient(id_cliente);

            //CREAMOS UNA TABLA, LISTAMOS LOS DATOS DEL CLIENTE Y LOS AÑADIMOS.
            PdfPTable tablaCliente = new PdfPTable(5);

            tablaCliente.addCell("ID");
            tablaCliente.addCell("Nombre");
            tablaCliente.addCell("Domicilio");
            tablaCliente.addCell("Teléfono");
            tablaCliente.addCell("Correo");

            tablaCliente.addCell(Integer.toString(c.getId_cliente()));
            tablaCliente.addCell(c.getNombre());
            tablaCliente.addCell(c.getDomicilio());
            tablaCliente.addCell(c.getTelefono());
            tablaCliente.addCell(c.getCorreo());

            //AÑADIMOS LA TABLA CON LOS DATOS DEL CLIENTE
            d.add(tablaCliente);

            //CREAMOS EL PARRAFO PARA LA TABLA CON LOS EQUIPOS DEL CLIENTE.
            Paragraph p_equipos = new Paragraph();
            p_equipos.setAlignment(Chunk.ALIGN_CENTER);
            p_equipos.setFont(FontFactory.getFont("Arial", 16, Font.BOLD));
            p_equipos.add("\n \n Equipos del Cliente \n \n");

            //AÑADIMOS EL PARRAFO
            d.add(p_equipos);

            //VERIFICAMOS SI EL CLIENTE TIENE EQUIPOS REGISTRADOS EN LA BBDD
            if (!equipos.isEmpty()) {

                //CREAMOS UNA TABLA PARA LOS EQUIPOS DEL CLIENTE Y LISTAMOS DATOS.
                PdfPTable tablaEquipos = new PdfPTable(7);

                tablaEquipos.addCell("Tipo de Equipo");
                tablaEquipos.addCell("Marca");
                tablaEquipos.addCell("Modelo");
                tablaEquipos.addCell("Fecha de Ingreso");
                tablaEquipos.addCell("Observaciones");
                tablaEquipos.addCell("Estatus");
                tablaEquipos.addCell("Comentarios");

                for (Equipo e : equipos) {

                    tablaEquipos.addCell(e.getTipo_equipo());
                    tablaEquipos.addCell(e.getMarca());
                    tablaEquipos.addCell(e.getModelo());

                    //SE LE APLICA UN FORMATO A LA FECHA AL MOMENTO DE IMPRIMIRLA.
                    String patron = "yyyy-MM-dd";
                    SimpleDateFormat formato = new SimpleDateFormat(patron);

                    String fecha = formato.format(e.getFecha_ingreso());

                    tablaEquipos.addCell(fecha);
                    tablaEquipos.addCell(e.getObservaciones());
                    tablaEquipos.addCell(e.getEstatus());
                    tablaEquipos.addCell(e.getComentarios_tecnicos());
                }

                //AÑADIMOS LA TABLA DE EQUIPOS
                d.add(tablaEquipos);

            } else {

                //DE NO TENER EQUIPOS REGISRADOS, MOSTRAMOS ESTE MENSAJE
                Paragraph p_mensaje = new Paragraph();
                p_mensaje.setAlignment(Chunk.ALIGN_CENTER);
                p_mensaje.setFont(FontFactory.getFont("Arial", 14, Font.BOLD));
                p_mensaje.add("No hay equipos registrados actualmente. \n \n");

                d.add(p_mensaje);

            }

            //CERRAMOS EL DOCUMENTO.
            d.close();

            JOptionPane.showMessageDialog(null, "¡Reporte de cliente creado exitosamente en el escritorio!");

        } catch (DocumentException | HeadlessException | IOException e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al listar datos y crear el reporte!");

        }

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

    private ClienteDAO clienteDao;
}
