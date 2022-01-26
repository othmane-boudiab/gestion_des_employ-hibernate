package com.example.gestion_employer1.servlet;

import com.example.gestion_employer1.configurationThymeleaf.TemplateEngineUtil;
import com.example.gestion_employer1.dao.implementation.EmployerDaoImp;
import com.example.gestion_employer1.dao.implementation.RoleDaoImp;
import com.example.gestion_employer1.dao.interfaces.EmployerDao;
import com.example.gestion_employer1.dao.interfaces.RoleDao;
import com.example.gestion_employer1.entity.EmployerEntity;
import com.example.gestion_employer1.entity.RoleEntity;
import com.example.gestion_employer1.repository.AdminRepoImp;
import com.example.gestion_employer1.repository.AdminRepoInt;

import com.example.gestion_employer1.services.implementations.EmployerServiceImp;
import com.example.gestion_employer1.services.implementations.RoleServiceImp;
import com.example.gestion_employer1.services.interfaces.EmployerService;
import com.example.gestion_employer1.services.interfaces.RoleService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet( "/")
public class ServletEmployer extends HttpServlet {
    private static  final Long serialVersionUID = 1L;
    private EmployerDao employerDao;
    TemplateEngine engine;
    WebContext context;
    AdminRepoInt adminRepoInt;

    public ServletEmployer() {
        employerDao = new EmployerDaoImp();
        this.adminRepoInt = new AdminRepoImp();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getServletPath();

            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                case "/list":
                    listUser(request, response);
                    break;
                case "/login":
                    try {
                        authenticate(request, response);
                    } catch (Exception e) {
                        e.printStackTrace();
                        response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        out.println("Connexion echouée! Email ou mot de passe incorrect ");
                        showLoginForm(request, response);
                    }
                    break;
                case "/logout":
                    response.setContentType("text/html");
                    PrintWriter out = response.getWriter();
                    out.println("Merci!, votre session a été supprimée avec succés!");
                    HttpSession session = request.getSession(false);
                    // session.setAttribute("user", null);
                    // session.removeAttribute("userr");
                    // session.getMaxInactiveInterval();
                    showLoginForm(request, response);
                    break;
                default:
                    showLoginForm(request, response);
                    break;
            }


    }

    private void setAsGone(HttpServletRequest request, HttpServletResponse response) {
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (adminRepoInt.validate(email,password)) {
            listUser(request, response);
        } else {

            throw new Exception("Login not successful..");
        }
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) {
        this.engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        this.context = new WebContext(request, response, request.getServletContext());
        response.setCharacterEncoding("utf-8");
        try {
            engine.process("login.html", context, response.getWriter());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<EmployerEntity> employers = employerDao.getAll();
        this.engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        this.context = new WebContext(request,response,request.getServletContext());
        response.setCharacterEncoding("utf-8");
        context.setVariable("users",employers);
        engine.process("listeEmployer.html", context, response.getWriter());


    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        Long id = new Long(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        long id_role = Long.parseLong(request.getParameter("role"));
        RoleEntity role = new RoleServiceImp().find(id_role);
        EmployerEntity employerEntity = new EmployerEntity(nom,prenom,email,password,role,id);
        EmployerService employerService = new EmployerServiceImp();
        employerService.update(employerEntity);
        listUser(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        this.engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        this.context = new WebContext(request, response, request.getServletContext());
        response.setCharacterEncoding("utf-8");
        Long id =Long.parseLong(request.getParameter("id"));
        EmployerEntity existingUser = employerDao.find(id);
        context.setVariable("edituser", existingUser);
        engine.process("editeUser.html", context, response.getWriter());
        System.out.println(existingUser);

    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        Long id = new Long(request.getParameter("id"));
        employerDao.delete(id);
        listUser(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        this.engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        this.context = new WebContext(request, response, request.getServletContext());
        response.setCharacterEncoding("utf-8");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        long id_role = Long.parseLong(request.getParameter("role"));
        RoleEntity role = new RoleServiceImp().find(id_role);
        EmployerEntity employerEntity = new EmployerEntity(nom,prenom,email,password,role);



        try {
            employerDao.add(employerEntity);
            response.sendRedirect("list");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }




    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        this.engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        this.context = new WebContext(request, response, request.getServletContext());
        response.setCharacterEncoding("utf-8");
        engine.process("addEmployer.html", context, response.getWriter());
    }

}
