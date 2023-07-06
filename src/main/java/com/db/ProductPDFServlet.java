package com.db; 

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.jasper.runtime.JspContextWrapper;
import org.apache.jasper.runtime.JspFactoryImpl;
import org.apache.jasper.runtime.PageContextImpl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@WebServlet("/productPDF")
public class ProductPDFServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve the list of products from your Java class
            List<ProductModal> itemList = FetchProducts.getProductsList();

            // Create a new document
            Document document = new Document();

            // Set the response content type and headers for PDF file
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\"products.pdf\"");

            // Get the response output stream
            OutputStream out = response.getOutputStream();
            PdfWriter writer = PdfWriter.getInstance(document, out);

            // Open the document
            document.open();

            // Iterate through the products and add content to the PDF document
            for (ProductModal item : itemList) {
                // Add product information to the document
                Paragraph productName = new Paragraph(item.getProductName());
                Paragraph functionality = new Paragraph(item.getFunctionality());
                Paragraph performance = new Paragraph(item.getPerformance());
                Paragraph usability = new Paragraph(item.getUsability());
                Paragraph cost = new Paragraph(item.getCost());
                Paragraph value = new Paragraph(item.getValue());
                Paragraph environmentalImpact = new Paragraph(item.getEnvironmentalImpact());

                document.add(productName);
                document.add(functionality);
                document.add(performance);
                document.add(usability);
                document.add(cost);
                document.add(value);
                document.add(environmentalImpact);

                // Add spacing between products
                document.add(new Paragraph("\n"));
            }

            // Close the document
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
