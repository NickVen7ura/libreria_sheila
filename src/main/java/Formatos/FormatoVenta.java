package Formatos;

import DAO.MysqlVentasDAO;
import Vista.vistaVenta;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ListSelectionModel;

public class FormatoVenta {

    public static void formatoTabla(vistaVenta vv) {
        //Metodo que permite solo 1 selección
        ListSelectionModel sele = vv.tblComic_venta.getSelectionModel();
        ListSelectionModel sele1 = vv.tblListaVender.getSelectionModel();
        sele.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sele1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        vv.tblComic_venta.setDefaultEditor(Object.class, null);
        vv.tblListaVender.setDefaultEditor(Object.class, null);
    }

    public static void formatoInicial(vistaVenta vv) {
        vv.btnEliminar.setEnabled(false);
        vv.btnEditar.setEnabled(false);
        vv.btnVaciar.setEnabled(false);
        vv.btnVender.setEnabled(false);
        vv.spnCantidad2.setEnabled(false);
        vv.btnActualizar.setEnabled(false);
        vv.txfNombreBuscar.requestFocus();
    }

    public static void formato1(vistaVenta vv) {
        vv.btnEliminar.setEnabled(true);
        vv.btnEditar.setEnabled(true);
        vv.btnVaciar.setEnabled(true);
        vv.btnVender.setEnabled(true);
        vv.spnCantidad2.setEnabled(false);
        vv.btnActualizar.setEnabled(false);
        vv.tblListaVender.setEnabled(true);
        vv.txfNombreBuscar.setEnabled(true);
        vv.spnCantidad.setEnabled(true);
        vv.tblComic_venta.setEnabled(true);
        vv.btnAgregar.setEnabled(true);
        vv.txfNombreBuscar.requestFocus();
    }

    public static void formato2(vistaVenta vv) {
        vv.btnEditar.setEnabled(false);
        vv.btnEliminar.setEnabled(false);
        vv.btnVaciar.setEnabled(false);
        vv.btnVender.setEnabled(false);
        vv.txfNombreBuscar.setEnabled(false);
        vv.tblComic_venta.setEnabled(false);
        vv.btnAgregar.setEnabled(false);
        vv.spnCantidad.setEnabled(false);
        vv.spnCantidad2.setEnabled(true);
        vv.btnActualizar.setEnabled(true);
        vv.tblListaVender.setEnabled(false);
    }

    public static void LimpiarCampos(vistaVenta vv) {
        vv.txfNombreBuscar.setText("");
        vv.spnCantidad.setValue(0);
        vv.spnCantidad2.setValue(0);
        vv.tblListaVender.clearSelection();
        vv.tblComic_venta.clearSelection();
        vv.txfNombreBuscar.requestFocus();
    }

    public static void generarPdf(int cod, MysqlVentasDAO mv) {
        Document doc = new Document();
        PdfWriter writer = null;  // Inicializar la variable PdfWriter

        try {
            String ruta = System.getProperty("user.dir");
            String nombreArchivo = ruta + "/src/main/java/facturaspdf/factura" + cod + ".pdf";
            FileOutputStream fileOutputStream = new FileOutputStream(nombreArchivo);
            writer = PdfWriter.getInstance(doc, fileOutputStream);
            doc.open();

            String rutaImagen = ruta + "/src/main/resources/img/imgparapdf.png";
            Image imagen = Image.getInstance(rutaImagen);
            imagen.setAlignment(Element.ALIGN_LEFT);
            imagen.scaleToFit(100, 100);

            doc.add(imagen);
            // Agregar un título al documento
            Paragraph titulo = new Paragraph("Empresa : Comic Crown");
            titulo.setAlignment(Element.ALIGN_RIGHT);
            titulo.setFont(FontFactory.getFont(FontFactory.HELVETICA, 5));
            doc.add(titulo);

            Paragraph fecha = new Paragraph("Fecha y Hora de Impresión: " + obtenerFechaHoraActual());
            fecha.setAlignment(Element.ALIGN_LEFT);
            fecha.setFont(FontFactory.getFont(FontFactory.HELVETICA, 5));
            doc.add(fecha);
            doc.add(Chunk.NEWLINE);

            Paragraph tel = new Paragraph("Telefono : 913746209");
            tel.setAlignment(Element.ALIGN_RIGHT);
            tel.setFont(FontFactory.getFont(FontFactory.HELVETICA, 5));
            doc.add(tel);

            Paragraph ruc = new Paragraph("RUC : 2584451325640");
            ruc.setAlignment(Element.ALIGN_LEFT);
            ruc.setFont(FontFactory.getFont(FontFactory.HELVETICA, 5));
            doc.add(ruc);
            doc.add(Chunk.NEWLINE);

            Paragraph die = new Paragraph("Dirección : Av. Sueños Mágicos 456,\n"
                    + "Urbanización Ilusión Norte,\n"
                    + "Distrito de Imaginaria,\n"
                    + "Lima Norte,\n"
                    + "Código Postal: 12345,\n"
                    + "Perú.");
            die.setAlignment(Element.ALIGN_LEFT);
            die.setFont(FontFactory.getFont(FontFactory.HELVETICA, 5));
            die.setLeading(15);
            doc.add(die);
            doc.add(Chunk.NEWLINE);

            Paragraph correo = new Paragraph("Correo : comiccrown@gmail.com");
            correo.setAlignment(Element.ALIGN_LEFT);
            correo.setFont(FontFactory.getFont(FontFactory.HELVETICA, 5));
            doc.add(correo);
            doc.add(Chunk.NEWLINE);

            PdfContentByte content = writer.getDirectContent();
            content.moveTo(doc.leftMargin(), doc.top() - 150);
            content.lineTo(doc.rightMargin(), doc.top() - 150);
            content.setLineWidth(0.5f);
            content.stroke();

            doc.add(Chunk.NEWLINE);
            
            Paragraph venta = new Paragraph("FACTURA DE LA VENTA");
            venta.setAlignment(Element.ALIGN_CENTER);
            venta.setFont(FontFactory.getFont(FontFactory.HELVETICA, 20));
            doc.add(venta);
            doc.add(Chunk.NEWLINE);
            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Nombre del Comic");
            tabla.addCell("Precio");
            tabla.addCell("Cantidad");
            mv = new MysqlVentasDAO();
            mv.consultapdf(tabla, doc, cod);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static String obtenerFechaHoraActual() {
        SimpleDateFormat formatoFechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date fechaHoraActual = new Date();
        return formatoFechaHora.format(fechaHoraActual);
    }
}
