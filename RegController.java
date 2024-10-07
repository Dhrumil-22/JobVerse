package com.Controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import com.DAO.RegDAO;
import com.VO.*;

/**
 * Servlet implementation class RegController
 */
@MultipartConfig
@WebServlet("/RegController")
public class RegController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private RegDAO regDAO = new RegDAO();

    public RegController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String flag = request.getParameter("flag");

        if (flag == null) {
            List<E_POST_RegVO> postList = regDAO.DashBoard();
            request.setAttribute("postList", postList);
            request.getRequestDispatcher("01_Main_Dashboard.jsp").forward(request, response);
        } else if (flag.equals("Js_Dash")) {
            List<E_POST_RegVO> postList = regDAO.DashBoard();
            request.setAttribute("postList", postList);
            request.getRequestDispatcher("JS_Dashboard.jsp").forward(request, response);
        } else if (flag.equals("Details")) {
            Details(request, response);
        } else if (flag.equals("emp_jobDetails")) {
            emp_jobDetails(request, response);
            response.sendRedirect("emp_jobdetail.jsp");
        } else if (flag.equals("emp_jobdetailedit")) {
            emp_jobDetails(request, response);
            response.sendRedirect("emp_jobdetailedit.jsp");
        } else if (flag.equals("Seepost")) {
            System.out.println("seepost");
            Seepost(request, response);
            response.sendRedirect("emp_post.jsp");
        } else if (flag.equals("delete")) {
            System.out.println("delete");
            delete(request, response);
            Seepost(request, response);
            response.sendRedirect("emp_post.jsp");
        } else if (flag.equals("deletespe")) {
            System.out.println("deletespe");
            deleteSpecific(request, response);
            Seepost(request, response);
            response.sendRedirect("emp_post.jsp");
        } else if (flag.equals("E_Post")) {
            E_Post(request, response);
            response.sendRedirect("E_Dashboard.jsp");
        } else if (flag.equals("edit")) {
            System.out.println("edit");
            edit(request, response);
            response.sendRedirect("edit_E_Post.jsp");
        } else if (flag.equals("Editspe")) {
            System.out.println("Editspe");
            editSpecific(request, response);
            response.sendRedirect("edit_E_Post.jsp");
        } else if (flag.equals("Apply")) {
            System.out.println("Apply");
            Apply(request, response);
            response.sendRedirect("Success_apply.jsp");
        } else if (flag.equals("notification")) {
            System.out.println("notification");
            notification(request, response);
            response.sendRedirect("Notification.jsp");
        } else if (flag.equals("E_acc")) {
            System.out.println("E_acc");
            E_acc(request, response);
            response.sendRedirect("e_Account.jsp");
        } else if (flag.equals("JS_acc")) {
            System.out.println("JS_acc");
            JS_acc(request, response);
            response.sendRedirect("JS_Account.jsp");
        }



    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String flag = request.getParameter("flag");
        if (flag.equals("Job-seeker")) {
            js_insert(request, response);
            response.sendRedirect("Login.jsp");
        } else if (flag.equals("Employer")) {
            e_insert(request, response);
            response.sendRedirect("Login.jsp");
        } else if (flag.equals("Login")) {
            login(request, response);
        } else if (flag.equals("Post")) {
            Insert_Post(request, response);
            Insert_Post2(request, response);
            response.sendRedirect("E_Post.jsp");
        } else if (flag.equals("Search")) {
            SearchBar(request, response);
        } else if (flag.equals("Update")) {
            update(request, response);
            Seepost(request, response);
            response.sendRedirect("emp_post.jsp");
        } else if (flag.equals("Check")) {
            CheckPass(request, response);
        } else if (flag.equals("E_Reset")) {
            EResetPass(request, response);
            response.sendRedirect("Login.jsp");
        } else if (flag.equals("JS_Reset")) {
            JSResetPass(request, response);
            response.sendRedirect("Login.jsp");
        } else if (flag.equals("Resume")) {
            Resume(request, response);
            JS_acc(request, response);
            response.sendRedirect("JS_Account.jsp");           
        }
    }

    // login
    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String Un = request.getParameter("UserName");
        String Pass = request.getParameter("Password");

        ServletContext application = request.getServletContext();
        application.setAttribute("Un", request.getParameter("UserName"));
        application.setAttribute("Pass", request.getParameter("Password"));

        RegDAO regDAO = new RegDAO();
        Object user = regDAO.login(Un, Pass);

        if (user instanceof JS_RegVO) {
            E_Post(request, response);
            response.sendRedirect("JS_Dashboard.jsp");
        } else if (user instanceof E_RegVO) {
            E_Post(request, response);
            response.sendRedirect("E_Dashboard.jsp");
        } else {
            response.sendRedirect("login.jsp?error=invalid");
        }
    }

    // Job-seeker Register
    protected void js_insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String Fn = request.getParameter("JS_FirstName");
        String Ln = request.getParameter("JS_LastName");
        String Em = request.getParameter("JS_Email");
        String Un = request.getParameter("JS_UserName");
        String Pass = request.getParameter("JS_Password");
        String Bf = request.getParameter("JS_Bestf");
        String Edu = request.getParameter("JS_Education");
        String City = request.getParameter("JS_CurrentCity");
        String State = request.getParameter("JS_CurrentState");
        
        Part profilePicPart = request.getPart("profilePic");

        byte[] profilePic = null;
        if (profilePicPart != null && profilePicPart.getSize() > 0) {
            // Convert uploaded file to byte array
            profilePic = IOUtils.toByteArray(profilePicPart.getInputStream());
        }

        JS_RegVO js_regVO = new JS_RegVO();
        js_regVO.setFirstName(Fn);
        js_regVO.setLastName(Ln);
        js_regVO.setEmail(Em);
        js_regVO.setUserName(Un);
        js_regVO.setPassword(Pass);
        js_regVO.setEducation(Edu);
        js_regVO.setBest(Bf);
        js_regVO.setCurrentCity(City);
        js_regVO.setCurrentState(State);
        js_regVO.setProfilePic(profilePic);

        RegDAO regDAO = new RegDAO();
        regDAO.js_insert(js_regVO);

    }

    // Employer Register

    protected void e_insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form fields
        String Fn = request.getParameter("E_FirstName");
        String Ln = request.getParameter("E_LastName");
        String Em = request.getParameter("E_Email");
        String Un = request.getParameter("E_UserName");
        String Pass = request.getParameter("E_Password");
        String Bf = request.getParameter("E_Bestf");
        String Ind = request.getParameter("E_Industry");
        String Com = request.getParameter("E_CompanyName");
        String City = request.getParameter("E_CurrentCity");
        String State = request.getParameter("E_CurrentState");

        // Get the uploaded profile picture (input name="profilePic")
        Part profilePicPart = request.getPart("profilePic");

        byte[] profilePic = null;
        if (profilePicPart != null && profilePicPart.getSize() > 0) {
            // Convert uploaded file to byte array
            profilePic = IOUtils.toByteArray(profilePicPart.getInputStream());
        }

        // Create the E_RegVO object
        E_RegVO E_regVO = new E_RegVO();
        E_regVO.setFirstName(Fn);
        E_regVO.setLastName(Ln);
        E_regVO.setEmail(Em);
        E_regVO.setUserName(Un);
        E_regVO.setPassword(Pass);
        E_regVO.setBest(Bf);
        E_regVO.setIndustry(Ind);
        E_regVO.setCompanyName(Com);
        E_regVO.setCurrentCity(City);
        E_regVO.setCurrentState(State);

        // Set the profile picture byte array in E_RegVO
        E_regVO.setProfilePic(profilePic);

        // Insert into database using DAO
        RegDAO regDAO = new RegDAO();
        regDAO.e_insert(E_regVO);

        // Optionally redirect or show success message
    }
    
    protected void Resume(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	ServletContext application = request.getServletContext();
    	String username = (String)application.getAttribute("Un");
    	
    	System.out.println(username);
         
        if (username == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not logged in");
            return;
        }

        Part resumePart = request.getPart("resume");
        byte[] resumePic = null;

        if (resumePart != null && resumePart.getSize() > 0) {
            resumePic = IOUtils.toByteArray(resumePart.getInputStream());
        }

        if (resumePic == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "No file uploaded");
            return;
        }

        RegDAO regDAO = new RegDAO();
        regDAO.updateResume(username, resumePic);
 // Redirect to a success page or handle accordingly
    }



    

    // post ne database ma insert karva
    protected void Insert_Post(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieving parameters from the form
        String username = request.getParameter("Username");  // Matching 'name' attribute in JSP
        String technology = request.getParameter("technology");
        String jobRole = request.getParameter("jobRole");
        String department = request.getParameter("department");
        String employmentType = request.getParameter("employmentType");
        String location = request.getParameter("location");
        String experience = request.getParameter("experience");
        String companyName = request.getParameter("companyName");
        String companyWebsite = request.getParameter("companyWebsite");
        String companyAddress = request.getParameter("companyAddress");
        String contactPerson = request.getParameter("contactPerson");
        String contactEmail = request.getParameter("contactEmail");
        String contactPhone = request.getParameter("contactPhone");
        String jobDescription = request.getParameter("jobDescription");
        String essentialSkills = request.getParameter("essentialSkills");
        String additionalRequirements = request.getParameter("additionalRequirements");
        String minEducation = request.getParameter("minEducation");
        String preferredQualification = request.getParameter("preferredQualification");

        // Setting parameters in the VO (Value Object)
        E_POST_RegVO e_post_regVO = new E_POST_RegVO();
        e_post_regVO.setUsername(username);
        e_post_regVO.setTechnology(technology);
        e_post_regVO.setJobRole(jobRole);
        e_post_regVO.setDepartment(department);
        e_post_regVO.setEmploymentType(employmentType);
        e_post_regVO.setLocation(location);
        e_post_regVO.setExperience(experience);
        e_post_regVO.setCompanyName(companyName);
        e_post_regVO.setCompanyWebsite(companyWebsite);
        e_post_regVO.setCompanyAddress(companyAddress);
        e_post_regVO.setContactPerson(contactPerson);
        e_post_regVO.setContactEmail(contactEmail);
        e_post_regVO.setContactPhone(contactPhone);
        e_post_regVO.setJobDescription(jobDescription);
        e_post_regVO.setEssentialSkills(essentialSkills);
        e_post_regVO.setAdditionalRequirements(additionalRequirements);
        e_post_regVO.setMinEducation(minEducation);
        e_post_regVO.setPreferredQualification(preferredQualification);

        // Inserting the data into the database via DAO
        RegDAO regDAO = new RegDAO();
        regDAO.insert_post(e_post_regVO);
    }


    // post ne database ma insert karva
    protected void Insert_Post2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("Username");  // Matching 'name' attribute in JSP
        String technology = request.getParameter("technology");
        String jobRole = request.getParameter("jobRole");
        String department = request.getParameter("department");
        String employmentType = request.getParameter("employmentType");
        String location = request.getParameter("location");
        String experience = request.getParameter("experience");
        String companyName = request.getParameter("companyName");
        String companyWebsite = request.getParameter("companyWebsite");
        String companyAddress = request.getParameter("companyAddress");
        String contactPerson = request.getParameter("contactPerson");
        String contactEmail = request.getParameter("contactEmail");
        String contactPhone = request.getParameter("contactPhone");
        String jobDescription = request.getParameter("jobDescription");
        String essentialSkills = request.getParameter("essentialSkills");
        String additionalRequirements = request.getParameter("additionalRequirements");
        String minEducation = request.getParameter("minEducation");
        String preferredQualification = request.getParameter("preferredQualification");

        // Setting parameters in the VO (Value Object)
        E_POST_RegVO2 e_post_regVO2 = new E_POST_RegVO2();
        e_post_regVO2.setUsername(username);
        e_post_regVO2.setTechnology(technology);
        e_post_regVO2.setJobRole(jobRole);
        e_post_regVO2.setDepartment(department);
        e_post_regVO2.setEmploymentType(employmentType);
        e_post_regVO2.setLocation(location);
        e_post_regVO2.setExperience(experience);
        e_post_regVO2.setCompanyName(companyName);
        e_post_regVO2.setCompanyWebsite(companyWebsite);
        e_post_regVO2.setCompanyAddress(companyAddress);
        e_post_regVO2.setContactPerson(contactPerson);
        e_post_regVO2.setContactEmail(contactEmail);
        e_post_regVO2.setContactPhone(contactPhone);
        e_post_regVO2.setJobDescription(jobDescription);
        e_post_regVO2.setEssentialSkills(essentialSkills);
        e_post_regVO2.setAdditionalRequirements(additionalRequirements);
        e_post_regVO2.setMinEducation(minEducation);
        e_post_regVO2.setPreferredQualification(preferredQualification);

        RegDAO regDAO = new RegDAO();
        regDAO.insert_post2(e_post_regVO2);

    }

    // Employer ae mukeli post ne job-seeker na dashboard par dekhdva
    protected void E_Post(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List SearchList = new ArrayList();
        RegDAO regDAO = new RegDAO();
        SearchList = regDAO.E_Post();
        HttpSession session = request.getSession();
        session.setAttribute("SearchList", SearchList);

    }

    // user ae mukeli post ne "MY POST" ma jova
    protected void Seepost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext application = request.getServletContext();
        Object Un = application.getAttribute("Un");
        System.out.println(Un);

        List<E_POST_RegVO> searchList = regDAO.Seepost(Un);
        HttpSession session = request.getSession();
        session.setAttribute("SearchList1", searchList);

    }

    // speficif detail of job
    protected void Details(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ServletContext application = request.getServletContext();
        application.setAttribute("id", Integer.parseInt(request.getParameter("id")));

        List SearchList = new ArrayList();
        RegDAO regDAO2 = new RegDAO();
        SearchList = regDAO2.Details(id);
        HttpSession session = request.getSession();
        session.setAttribute("DetailList", SearchList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("JobDetail.jsp");
        dispatcher.forward(request, response);
    }

    protected void emp_jobDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ServletContext application = request.getServletContext();
        application.setAttribute("Id", Integer.parseInt(request.getParameter("id")));

        List SearchList = new ArrayList();
        RegDAO regDAO2 = new RegDAO();
        SearchList = regDAO2.Details(id);
        HttpSession session = request.getSession();
        session.setAttribute("EmpDetailList", SearchList);
    }

    // Search-Bar
    protected void SearchBar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String searchTerm = request.getParameter("Search");
        RegDAO regDAO = new RegDAO();
        List<E_POST_RegVO> searchList = regDAO.searchBar(searchTerm);
        HttpSession session = request.getSession();
        session.setAttribute("List", searchList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("JS_Search.jsp");
        dispatcher.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        E_POST_RegVO E_POST_RegVO = new E_POST_RegVO();
        E_POST_RegVO.setId(id);

        RegDAO regDAO2 = new RegDAO();
        regDAO2.Delete(E_POST_RegVO);

    }

    protected void deleteSpecific(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext application = request.getServletContext();
        Integer id = (Integer) application.getAttribute("Id");

        System.out.println(id);

        E_POST_RegVO E_POST_RegVO = new E_POST_RegVO();
        E_POST_RegVO.setId(id);

        RegDAO regDAO2 = new RegDAO();
        regDAO2.Delete(E_POST_RegVO);

    }

    public void edit(HttpServletRequest request, HttpServletResponse response) {
        List SearchList = new ArrayList();

        int id = Integer.parseInt(request.getParameter("id"));

        RegDAO regDAO = new RegDAO();
        SearchList = regDAO.edit(id);

        HttpSession session = request.getSession();
        session.setAttribute("editList", SearchList);

    }

    public void editSpecific(HttpServletRequest request, HttpServletResponse response) {
        List SearchList = new ArrayList();

        ServletContext application = request.getServletContext();
        Integer id = (Integer) application.getAttribute("Id");

        RegDAO regDAO = new RegDAO();
        SearchList = regDAO.edit(id);

        HttpSession session = request.getSession();
        session.setAttribute("editList", SearchList);

    }

    public void update(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");  // Matching 'name' attribute in JSP
        String technology = request.getParameter("technology");
        String jobRole = request.getParameter("jobRole");
        String department = request.getParameter("department");
        String employmentType = request.getParameter("employmentType");
        String location = request.getParameter("location");
        String experience = request.getParameter("experience");
        String companyName = request.getParameter("companyName");
        String companyWebsite = request.getParameter("companyWebsite");
        String companyAddress = request.getParameter("companyAddress");
        String contactPerson = request.getParameter("contactPerson");
        String contactEmail = request.getParameter("contactEmail");
        String contactPhone = request.getParameter("contactPhone");
        String jobDescription = request.getParameter("jobDescription");
        String essentialSkills = request.getParameter("essentialSkills");
        String additionalRequirements = request.getParameter("additionalRequirements");
        String minEducation = request.getParameter("minEducation");
        String preferredQualification = request.getParameter("preferredQualification");
        String id = request.getParameter("id");

        E_POST_RegVO e_post_regVO = new E_POST_RegVO();
        e_post_regVO.setUsername(username);
        e_post_regVO.setTechnology(technology);
        e_post_regVO.setJobRole(jobRole);
        e_post_regVO.setDepartment(department);
        e_post_regVO.setEmploymentType(employmentType);
        e_post_regVO.setLocation(location);
        e_post_regVO.setExperience(experience);
        e_post_regVO.setCompanyName(companyName);
        e_post_regVO.setCompanyWebsite(companyWebsite);
        e_post_regVO.setCompanyAddress(companyAddress);
        e_post_regVO.setContactPerson(contactPerson);
        e_post_regVO.setContactEmail(contactEmail);
        e_post_regVO.setContactPhone(contactPhone);
        e_post_regVO.setJobDescription(jobDescription);
        e_post_regVO.setEssentialSkills(essentialSkills);
        e_post_regVO.setAdditionalRequirements(additionalRequirements);
        e_post_regVO.setMinEducation(minEducation);
        e_post_regVO.setPreferredQualification(preferredQualification);
        e_post_regVO.setId(Integer.parseInt(id));

        E_POST_RegVO2 e_post_regVO2 = new E_POST_RegVO2();
        e_post_regVO2.setUsername(username);
        e_post_regVO2.setTechnology(technology);
        e_post_regVO2.setJobRole(jobRole);
        e_post_regVO2.setDepartment(department);
        e_post_regVO2.setEmploymentType(employmentType);
        e_post_regVO2.setLocation(location);
        e_post_regVO2.setExperience(experience);
        e_post_regVO2.setCompanyName(companyName);
        e_post_regVO2.setCompanyWebsite(companyWebsite);
        e_post_regVO2.setCompanyAddress(companyAddress);
        e_post_regVO2.setContactPerson(contactPerson);
        e_post_regVO2.setContactEmail(contactEmail);
        e_post_regVO2.setContactPhone(contactPhone);
        e_post_regVO2.setJobDescription(jobDescription);
        e_post_regVO2.setEssentialSkills(essentialSkills);
        e_post_regVO2.setAdditionalRequirements(additionalRequirements);
        e_post_regVO2.setMinEducation(minEducation);
        e_post_regVO2.setPreferredQualification(preferredQualification);
        e_post_regVO2.setId(Integer.parseInt(id));


        RegDAO regDAO = new RegDAO();
        regDAO.update(e_post_regVO,e_post_regVO2);
    }

    public void Apply(HttpServletRequest request, HttpServletResponse response) {


        ServletContext application = request.getServletContext();
        Object un = application.getAttribute("Un");
        System.out.println(un);

        Integer id = (Integer) application.getAttribute("id");
        
        RegDAO regDAO = new RegDAO();
        regDAO.Apply(id,un);
        
        

    }

    protected void notification(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext application = request.getServletContext();
        Object Un = application.getAttribute("Un");
        System.out.println(Un);

        List<Applied_RegVO> searchList = regDAO.notification(Un);
        HttpSession session = request.getSession();
        session.setAttribute("ApplytList", searchList);
        
        
        
        String imagePath = application.getRealPath("/Image"); // Gets the absolute path of the Image folder

        // Ensure that the directory exists
        File imageDir = new File(imagePath);
        if (!imageDir.exists()) {
            imageDir.mkdirs(); // Create the directory if it doesn't exist
        }

        for (Applied_RegVO item : searchList) {
            byte[] imageData = item.getProfilePic();
            byte[] resumeData = item.getResume();

            // Handling Profile Picture
            if (imageData != null && imageData.length > 0) {
                InputStream inputStream = new ByteArrayInputStream(imageData);

                // Generate a unique name for the image, e.g., using the user ID or a timestamp
                String imageFileName = "profile_pic_" + item.getId() + ".jpg";
                String outputFilePath = imagePath + File.separator + imageFileName;

                try (FileOutputStream outputStream = new FileOutputStream(outputFilePath)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    inputStream.close();
                    System.out.println("Profile picture saved to " + outputFilePath);
                    
                } catch (IOException e) {
                    System.err.println("Error saving profile picture: " + e.getMessage());
                }
            }

            // Handling Resume
            if (resumeData != null && resumeData.length > 0) {
                InputStream inputStream = new ByteArrayInputStream(resumeData);

                // Generate a unique name for the resume
                String resumeFileName = "resume_" + item.getId() + ".jpg";  // Assuming it's a PDF
                String outputFilePath = imagePath + File.separator + resumeFileName;

                try (FileOutputStream outputStream = new FileOutputStream(outputFilePath)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    inputStream.close();
                    System.out.println("Resume saved to " + outputFilePath);

                } catch (IOException e) {
                    System.err.println("Error saving resume: " + e.getMessage());
                }
            }
        }
        


    }

    protected void E_acc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Handle regular data requests
        ServletContext application = request.getServletContext();
        Object Un = application.getAttribute("Un");
        System.out.println(Un);

        // Fetch the data from the database
        List<E_RegVO> searchList = regDAO.E_acc(Un);
        HttpSession session = request.getSession();
        session.setAttribute("E_acc", searchList);
        

        // Get the absolute path to the Image folder
        String imagePath = application.getRealPath("/Image"); // Gets the absolute path of the Image folder

        // Ensure that the directory exists
        File imageDir = new File(imagePath);
        if (!imageDir.exists()) {
            imageDir.mkdirs(); // Create the directory if it doesn't exist
        }

        for (E_RegVO item : searchList) {
            byte[] imageData = item.getProfilePic(); 

            if (imageData != null && imageData.length > 0) {
                InputStream inputStream = new ByteArrayInputStream(imageData);

                // Create a unique name for the image
                String outputFilePath = imagePath + File.separator + item.getProfilePic() + ".jpg";
                FileOutputStream outputStream = new FileOutputStream(outputFilePath);

                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                inputStream.close();
                outputStream.close();

                System.out.println("Image saved to " + outputFilePath);
                
            }
        }
      
        
    }





    protected void JS_acc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext application = request.getServletContext();
        Object Un = application.getAttribute("Un");
        System.out.println(Un);

        List<JS_RegVO> searchList = regDAO.JS_acc(Un);
        HttpSession session = request.getSession();
        session.setAttribute("JS_acc", searchList);
        
        // Get the absolute path to the Image folder
        String imagePath = application.getRealPath("/Image"); // Gets the absolute path of the Image folder

        // Ensure that the directory exists
        File imageDir = new File(imagePath);
        if (!imageDir.exists()) {
            imageDir.mkdirs(); // Create the directory if it doesn't exist
        }

        for (JS_RegVO item : searchList) {
            byte[] imageData = item.getProfilePic();
            byte[] resumeData = item.getResume();

            // Handling Profile Picture
            if (imageData != null && imageData.length > 0) {
                InputStream inputStream = new ByteArrayInputStream(imageData);

                // Generate a unique name for the image, e.g., using the user ID or a timestamp
                String imageFileName = "profile_pic_" + item.getId() + ".jpg";
                String outputFilePath = imagePath + File.separator + imageFileName;

                try (FileOutputStream outputStream = new FileOutputStream(outputFilePath)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    inputStream.close();
                    System.out.println("Profile picture saved to " + outputFilePath);
                    
                } catch (IOException e) {
                    System.err.println("Error saving profile picture: " + e.getMessage());
                }
            }

            // Handling Resume
            if (resumeData != null && resumeData.length > 0) {
                InputStream inputStream = new ByteArrayInputStream(resumeData);

                // Generate a unique name for the resume
                String resumeFileName = "resume_" + item.getId() + ".jpg";  // Assuming it's a PDF
                String outputFilePath = imagePath + File.separator + resumeFileName;

                try (FileOutputStream outputStream = new FileOutputStream(outputFilePath)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    inputStream.close();
                    System.out.println("Resume saved to " + outputFilePath);

                } catch (IOException e) {
                    System.err.println("Error saving resume: " + e.getMessage());
                }
            }
        }
    }



    protected void CheckPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String Un = request.getParameter("UserName");
        String Bf = request.getParameter("Bestf");

        ServletContext application = request.getServletContext();
        application.setAttribute("Un",request.getParameter("UserName"));


        RegDAO regDAO = new RegDAO();
        Object user = regDAO.CheckPass(Un, Bf);

        if (user instanceof JS_RegVO) {
            response.sendRedirect("jsreset_pass.jsp");
        } else if (user instanceof E_RegVO) {
            response.sendRedirect("ereset_pass.jsp");
        } else {
            response.sendRedirect("e_Privacy.jsp?error=invalid");
        }
    }

    protected void EResetPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext application = request.getServletContext();
        Object Un = application.getAttribute("Un");

        String Np = request.getParameter("NewPassword");
        String Cp = request.getParameter("CnfPassword");

        if (Np.equals(Cp)){

            RegDAO regDAO = new RegDAO();
            regDAO.EResetPass(Cp,Un);
        } else {
            response.sendRedirect("reset_pass.jsp?error=invalid");
        }
    }

    protected void JSResetPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext application = request.getServletContext();
        Object Un = application.getAttribute("Un");

        String Np = request.getParameter("NewPassword");
        String Cp = request.getParameter("CnfPassword");

        if (Np.equals(Cp)){

            RegDAO regDAO = new RegDAO();
            regDAO.JSResetPass(Cp,Un);
        } else {
            response.sendRedirect("reset_pass.jsp?error=invalid");
        }
    }



}