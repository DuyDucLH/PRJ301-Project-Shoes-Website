package controller;

/*
 * DuyDuc94
 */


import dal.ProductDAO;
import dal.Product_DetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Product;
import model.Product_Detail;

/**
 * @author duy20
 */
public class ViewProductServlet extends HttpServlet {

    //response.setContentType("text/html;charset=UTF-8");
    //request.setCharacterEncoding("UTF-8");
    //PrintWriter out = response.getWriter();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        int proID = Integer.parseInt(request.getParameter("proID"));
        String color = request.getParameter("color");
        ProductDAO proDAO = new ProductDAO();
        Product product = proDAO.getProductsByID(proID);
        List<Product> listRelatedProduct = proDAO.getRelatedProduct(product.getBrandID());
        Product_DetailDAO proDetDAO = new Product_DetailDAO();
        List<Product_Detail> listProductDetail = proDetDAO.getListProduct(proID);
        
        if(color!=null){
            Product_Detail proDetail = proDetDAO.getColor(proID, color);
            request.setAttribute("proDetail", proDetail);
        }
        
        request.setAttribute("product", product);
        request.setAttribute("listProductDetail", listProductDetail);
        request.setAttribute("listRelatedProduct", listRelatedProduct);
        request.getRequestDispatcher("view-product.jsp").forward(request, response);
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        
    }

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewProductServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewProductServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }     

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}