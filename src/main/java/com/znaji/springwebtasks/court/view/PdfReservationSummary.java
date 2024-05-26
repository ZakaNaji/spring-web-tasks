package com.znaji.springwebtasks.court.view;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.znaji.springwebtasks.court.demain.Reservation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Component("reservationSummary")
public class PdfReservationSummary extends AbstractPdfView {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE;
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document,
                                    PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        var reservations = (List<Reservation>) model.get("reservations");
        var table = new Table(5);
        addHeader(table);
        reservations.forEach(reservation -> addContent(table, reservation));
        document.add(table);
    }

    private void addContent(Table table, Reservation reservation) {
        table.addCell(reservation.getCourtName());
        table.addCell(DATE_FORMAT.format(reservation.getDate()));
        table.addCell(String.valueOf(reservation.getHour()));
        table.addCell(reservation.getPlayer().getName());
        table.addCell(reservation.getPlayer().getPhone());
    }

    private void addHeader(Table table) {
        table.addCell("Court Name");
        table.addCell("Date");
        table.addCell("Hour");
        table.addCell("Player Name");
        table.addCell("Player Phone");
    }
}
