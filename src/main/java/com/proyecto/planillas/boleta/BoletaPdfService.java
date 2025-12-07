package com.proyecto.planillas.boleta;

import java.awt.Color;
import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.proyecto.planillas.planilla.Planilla;
import com.proyecto.planillas.planilla.PlanillaRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BoletaPdfService {

    private final PlanillaRepository planillaRepository;

    public byte[] generarBoleta(Long planillaId) {

        Planilla p = planillaRepository.findById(planillaId)
                .orElseThrow(() -> new RuntimeException("Planilla no encontrada"));

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            Document document = new Document();
            PdfWriter.getInstance(document, out);

            document.open();

            // ===========================
            // ENCABEZADO ELEGANTE
            // ===========================
            Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Color.BLACK);
            Font subFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.DARK_GRAY);

            Paragraph titulo = new Paragraph("BOLETA DE PAGO", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);

            Paragraph empresa = new Paragraph("Centro Laboral - Planillas RRHH", subFont);
            empresa.setAlignment(Element.ALIGN_CENTER);

            Paragraph periodo = new Paragraph("Periodo: " + p.getMes() + "/" + p.getAnio(), subFont);
            periodo.setAlignment(Element.ALIGN_CENTER);

            document.add(titulo);
            document.add(empresa);
            document.add(periodo);

            document.add(new Paragraph("\n")); //espacio

            // ===========================
            // DATOS DEL EMPLEADO
            // ===========================
            PdfPTable tablaEmpleado = new PdfPTable(2);
            tablaEmpleado.setWidthPercentage(100);

            tablaEmpleado.addCell(celda("Empleado:", true));
            tablaEmpleado.addCell(celda(p.getEmpleado().getNombre() + " " + p.getEmpleado().getApellido(), false));

            tablaEmpleado.addCell(celda("Días trabajados:", true));
            tablaEmpleado.addCell(celda(p.getDiasTrabajados() + " días", false));

            tablaEmpleado.addCell(celda("Tardanzas:", true));
            tablaEmpleado.addCell(celda(p.getTardanzas() + " minutos", false));

            tablaEmpleado.addCell(celda("Inasistencias:", true));
            tablaEmpleado.addCell(celda(p.getInasistencias() + " faltas", false));

            tablaEmpleado.addCell(celda("Estado:", true));
            tablaEmpleado.addCell(celda(p.getEstado().name(), false));

            document.add(tablaEmpleado);
            document.add(new Paragraph("\n"));

            // ===========================
            // TABLA DE SUELDO
            // ===========================
            PdfPTable tablaSueldos = new PdfPTable(2);
            tablaSueldos.setWidthPercentage(100);

            tablaSueldos.addCell(celdaHeader("Descripción"));
            tablaSueldos.addCell(celdaHeader("Monto (S/.)"));

            tablaSueldos.addCell(celda("Sueldo Base:", true));
            tablaSueldos.addCell(celda(p.getSueldoBase().toString(), false));

            tablaSueldos.addCell(celda("Total Descuentos:", true));
            tablaSueldos.addCell(celda(p.getTotalDescuentos().toString(), false));

            PdfPCell celdaNeto = celdaBold("SUELDO NETO:", true);
            celdaNeto.setBackgroundColor(new Color(220, 220, 220));
            tablaSueldos.addCell(celdaNeto);

            PdfPCell celdaNetoMonto = celdaBold("S/. " + p.getSueldoNeto(), false);
            celdaNetoMonto.setBackgroundColor(new Color(220, 220, 220));
            tablaSueldos.addCell(celdaNetoMonto);

            document.add(tablaSueldos);

            document.add(new Paragraph("\n\n"));

            // ===========================
            // FIRMA
            // ===========================
            Paragraph firma = new Paragraph("____________________________________\nFirma del Empleado\n",
                    FontFactory.getFont(FontFactory.HELVETICA, 11));
            firma.setAlignment(Element.ALIGN_CENTER);

            document.add(firma);

            document.close();

            return out.toByteArray();

        } catch (DocumentException e) {
            throw new RuntimeException("Error generando PDF", e);
        }
    }

    private PdfPCell celda(String texto, boolean bold) {
        Font font = FontFactory.getFont(FontFactory.HELVETICA, 11, bold ? Font.BOLD : Font.NORMAL);
        PdfPCell cell = new PdfPCell(new Phrase(texto, font));
        cell.setPadding(6);
        return cell;
    }

    private PdfPCell celdaHeader(String texto) {
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
        PdfPCell cell = new PdfPCell(new Phrase(texto, font));
        cell.setPadding(7);
        cell.setBackgroundColor(new Color(200, 200, 200));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        return cell;
    }

    private PdfPCell celdaBold(String texto, boolean left) {
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
        PdfPCell cell = new PdfPCell(new Phrase(texto, font));
        cell.setPadding(6);
        if (!left) cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        return cell;
    }
}