package techPanther.controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import techPanther.modelo.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class usoEquipos {

    public usoEquipos() {

        equipoDao = new EquipoDAO();

    }

    public JTable listarEquipos() {

        List<Equipo> lista = equipoDao.selectEquipos();

        DefaultTableModel model = new DefaultTableModel();

        JTable tabla = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Tipo de Equipo");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Estatus");

        for (Equipo equipo : lista) {

            Object[] e = new Object[5];

            e[0] = equipo.getId_equipo();
            e[1] = equipo.getTipo_equipo();
            e[2] = equipo.getMarca();
            e[3] = equipo.getModelo();
            e[4] = equipo.getEstatus();

            model.addRow(e);

        }

        return tabla;

    }

    public JTable listarEquiposPorId(int id_cliente) {

        List<Equipo> lista = equipoDao.selectEquiposByIdClient(id_cliente);

        DefaultTableModel model = new DefaultTableModel();

        JTable tabla = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Tipo de Equipo");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Estatus");

        for (Equipo equipo : lista) {

            Object[] e = new Object[5];

            e[0] = equipo.getId_equipo();
            e[1] = equipo.getTipo_equipo();
            e[2] = equipo.getMarca();
            e[3] = equipo.getModelo();
            e[4] = equipo.getEstatus();

            model.addRow(e);

        }

        return tabla;

    }

    public boolean agregarEquipo(int id_cliente, String tipo_equipo, String marca, String modelo, String observaciones, Date fecha, String estatus) {

        if (!tipo_equipo.equals("") && !marca.equals("") && !observaciones.equals("") && !estatus.equals("")) {

            Equipo e = new Equipo(id_cliente, tipo_equipo, marca, modelo, fecha, observaciones, estatus, null, null);

            if (equipoDao.agregarEquipo(e)) {

                JOptionPane.showMessageDialog(null, "¡Equipo agregado correctamente!");
                return true;
            }

        } else {

            JOptionPane.showMessageDialog(null, "No debe dejar los campos obligatorios en blanco (marcados con *)");
            return false;
        }
        return false;
    }

    public boolean actualizarEquipo(int id_equipo, String tipo_equipo, String marca, String modelo, String observaciones, Date fecha, String estatus, String comentarios, String revisado_por) {

        if (!tipo_equipo.equals("") && !marca.equals("") && !observaciones.equals("") && !estatus.equals("")) {

            Equipo e = new Equipo(0, tipo_equipo, marca, modelo, fecha, observaciones, estatus, comentarios, revisado_por);
            e.setId_equipo(id_equipo);

            if (equipoDao.updateEquipo(e)) {

                JOptionPane.showMessageDialog(null, "¡Equipo actualizado correctamente!");
                return true;
            }

        } else {

            JOptionPane.showMessageDialog(null, "No debe dejar los campos obligatorios en blanco (marcados con *)");
            return false;
        }
        return false;
    }

    public Object[] obtenerEquipo(int id_equipo) {

        Equipo e = equipoDao.selectEquipoById(id_equipo);

        System.out.println("Leyendo resultados de equipo: " + e.getTipo_equipo() + ", " + e.getMarca() + ", " + e.getModelo());

        Object[] lista = new Object[8];

        lista[0] = e.getTipo_equipo();
        lista[1] = e.getMarca();
        lista[2] = e.getModelo();
        lista[3] = e.getFecha_ingreso();
        lista[4] = e.getObservaciones();
        lista[5] = e.getEstatus();
        lista[6] = e.getComentarios_tecnicos();
        lista[7] = e.getRevisado_por();

        return lista;

    }

    public int[] seleccionarEstatus() {

        List<String> lista = equipoDao.selectEstatus();

        int nuevo = 0;
        int revision = 0;
        int reparado = 0;
        int noReparado = 0;
        int entregado = 0;

        for (String string : lista) {

            if ("Nuevo Ingreso".equals(string)) {

                nuevo++;

            } else if ("En Revision".equals(string)) {

                revision++;

            } else if ("Reparado".equals(string)) {

                reparado++;

            } else if ("No Reparado".equals(string)) {

                noReparado++;

            } else if ("Entregado".equals(string)) {

                entregado++;

            }
        }

        int[] estatus = new int[5];

        estatus[0] = nuevo;
        estatus[1] = revision;
        estatus[2] = reparado;
        estatus[3] = noReparado;
        estatus[4] = entregado;

        return estatus;
    }

    //MÉTODO PARA IMPORTAR UNA TABLA DE EXCEL AL SISTEMA
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

    private EquipoDAO equipoDao;
}
