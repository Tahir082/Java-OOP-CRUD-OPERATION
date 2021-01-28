
package lab_prob_e;

import java.util.Scanner;

class Student{
    private int studentId;
    private String studentName;
    private double studentCGPA;
    static int stdcount=0;
    Student(){
        this.studentId=0;
        this.studentName=null;
        this.studentCGPA=0;
    }
    
    Student(int studentId, String studentName, double studentCGPA){
        this.studentId=studentId;
        this.studentName=studentName;
        this.studentCGPA=studentCGPA;
    }
    public int getStdId(){
        return this.studentId;
    }
    public String getStdName(){
        return this.studentName;
    }
    
    public double getStdCGPA(){
        return this.studentCGPA;
    }
    
    public String toString(){
        String str="Student Name: "+this.studentName+ "\n Student ID: "+this.studentId+"\n Student CGPA: "+this.studentCGPA;
        return str;
    }
}

class Course{
    private String courseId;
    private String courseTitle;
    private double credit;
    private Student[] studentList;
    private int numberOfstudents;
    private Faculty faculty;
    static int courseCount=0;
    static int c_s=0, c_f=0;
    
    Course(){
        this.courseId=null;
        this.courseTitle=null;
        this.credit=0;
    }
    
    Course(String courseId, String courseTitle, double credit){
        this.courseId=courseId;
        this.courseTitle=courseTitle;
        this.credit=credit;
    }
    
    public String getCourseId(){
        String crs_id= this.courseId;
        return crs_id;
    }
    
    public String getCourseTitle(){
        return this.courseTitle;
    }
    public double getCourseCredit(){
        return this.credit;
    }
    
    public String toString(){
        String str="Course ID: "+this.courseId+"\n Course Title: "+this.courseTitle+"\n Credit: "+this.credit ;
        return str;
    }
    
    public void addStudent(Student std){
        c_s++;
        studentList[c_s]=std;
    }
    public boolean findStd(int stdId){
        boolean found = false;
        for(int i=1; i<=c_s; i++)
        {
            int check=studentList[i].getStdId();
            if(check==stdId){
                found= true;
            }
        }
        return found;
    }
    public boolean findFac(int facId){
        boolean found = false;
        int check= faculty.getFacId();
        if(check==facId){
            found= true;
        }
        
        return found;
    }
    
    public void dropStudent(int studentId){
        for(int i=1; i<=c_s; i++){
            if(studentList[i].getStdId()== studentId){
                studentList[i]=null;
                System.out.println("Selected student dropped from this course successfully");
            }
        }
    }
    
    public void addFaculty(Faculty fc){
        c_f++;
        faculty= fc;
    }
    
    public void dropFaculty(){
        faculty=null;
    }
    
    public void printStudentList(){
        System.out.println("=======Faculty======");
        System.out.println(faculty.toString());
        System.out.println("");
        System.out.println("");
        System.out.println("=======Students=====");
        for(int i=1; i<c_s; i++){
            System.out.println(studentList[i].toString());
            System.out.println("");
        }
    }
    
}

class Faculty{
    private int facultyId;
    private String facultyName;
    private String facultyPosition;
    static int facCount=0;
    
    Faculty(){
        this.facultyId=0;
        this.facultyName=null;
        this.facultyPosition=null;
    }
    
    Faculty(int facultyId, String facultyName, String facultyPosition){
        this.facultyId=facultyId;
        this.facultyName=facultyName;
        this.facultyPosition=facultyPosition;
    }
    
    public int getFacId(){
        return this.facultyId;
    }
    
    public String getFacName(){
        return this.facultyName;
    }
    public String getFacPos(){
        return this.facultyPosition;
    }
    
    public String toString(){
        String str="Faculty Name: "+this.facultyName+"\n Faculty ID: "+this.facultyId+"\n Position: "+this.facultyPosition;
        return str;
    }
}

public class Lab_Prob_E {

    
    public static void main(String[] args) {
        int size=1000;
        Student std[]= new Student[size];
        Course crs[]= new Course[size];
        Faculty fac[]=new Faculty[size];
        while(true){
            int menu;
        Scanner in= new Scanner(System.in);
        System.out.println("Press 1: ADD.");
        System.out.println("Press 2: DELETE.");
        System.out.println("Press 3: UPDATE.");
        System.out.println("Press 4: PRINT.");
        System.out.println("Press 5: SEARCH.");
        menu= in.nextInt();
        switch(menu){
            case 1:
                System.out.println("===============ADD===============");
                System.out.println("Press 1: ADD STUDENT");
                System.out.println("Press 2: ADD COURSE");
                System.out.println("Press 3: ADD FACULTY");
                int submenu_1=in.nextInt();
                switch (submenu_1) {
                case 1:
                    while(true){
                        System.out.println("=============ADD STUDENTS============");
                        Student.stdcount++;
                        int c=Student.stdcount;
                        System.out.println("Student Name: ");
                        in.nextLine();
                        String std_name= in.nextLine();
                        System.out.println("Student ID has been set automatically by system....");
                        std[c]= new Student(c, std_name, 0);
                        System.out.println("Add more students? 1=yes / 0=no");
                        int choice= in.nextInt();
                        if(choice==0){
                            break;
                        }
                        
                    }
                    
                    break;
                case 2:
                    while(true){
                        System.out.println("===============ADD COURSES================");
                        Course.courseCount++;
                        int c2=Course.courseCount;
                        System.out.println("Course ID: ");
                        String c_id= in.nextLine();
                        System.out.println("Course Title: ");
                        String course_title= in.nextLine();
                        System.out.println("Course Credit: ");
                        int credit= in.nextInt();
                        System.out.println("Course ID has been set automatically by system....");
                        crs[c2]= new Course(c_id, course_title, 0);
                        System.out.println("Add more Courses? 1=yes / 0=no");
                        int choice= in.nextInt();
                        if(choice==0){
                            break;
                        }
                    }
                    
                    break;
                case 3:
                    while(true){
                        System.out.println("================ADD FACULTIES==============");
                        Faculty.facCount++;
                        int c3=Faculty.facCount;
                        System.out.println("Faculty Name: ");
                        in.nextLine();
                        String fac_name= in.nextLine();
                        System.out.println("Faculty ID has been set automatically by the system...");
                        System.out.println("Faculty Position: ");
                        String pos= in.nextLine();
                        fac[c3]=new Faculty(c3, fac_name, pos);
                        System.out.println("Add more Faculties? 1=yes / 0=no");
                        int choice= in.nextInt();
                        if(choice==0){
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Wrong Input!!! Try Again!!");
                    break;    
                }
                break;
            case 2:
                System.out.println("==================DELETE===================");
                System.out.println("Press 1: DELETE STUDENT");
                System.out.println("Press 2: DELETE COURSE");
                System.out.println("Press 3: DELETE FACULTY");
                int submenu_2=in.nextInt();
                switch (submenu_2) {
                case 1:
                    System.out.println("=============DELETE STUDENT=============");
                    System.out.println("Type Student ID: ");
                    int s_id= in.nextInt();
                    if(std[s_id]!= null)
                    {
                        std[s_id]=null;
                        System.out.println("Selected Student has been deleted.");
                    }
                    else{
                          System.out.println("Student information was not found!! Try again.");
                    }
                    
                    break;
                case 2:
                    System.out.println("===============DELETE COURSE===============");
                    System.out.println("Type Course ID: ");
                    String c_id= in.nextLine();
                    for(int i=1; i<=Course.courseCount; i++){
                        String check_id= crs[i].getCourseId();
                        if(check_id.equals(c_id)){
                            if(crs[i]!=null)
                            {
                                crs[i]=null;
                                System.out.println("Selected Course has been Deleted.");
                            }
                            else{
                                System.out.println("Course information not found!!! Try again!!!");
                            }
                            
                        }
                    } 
                    break;
                case 3:
                    System.out.println("================DELETE FACULTY===============");
                    System.out.println("Type Faculty ID: ");
                    int f_id= in.nextInt();
                    if(fac[f_id]!=null){
                        fac[f_id]=null;
                        System.out.println("Selected Faculty has been deleted.");
                    }
                    else{
                        System.out.println("Faculty information was not found!! Try again!!");
                    }
                    
                    break;
                default:
                    System.out.println("Wrong Input!!! Try Again!!");
                    break;    
                }
                break;
            case 3:
                System.out.println("===============UPDATE==============");
                System.out.println("Press 1: UPDATE STUDENT");
                System.out.println("Press 2: UPDATE COURSE");
                System.out.println("Press 3: UPDATE FACULTY");
                int submenu_3=in.nextInt();
                switch (submenu_3) {
                case 1:
                    System.out.println("=============UPDATE STUDENT============");
                    System.out.println("Type Student ID: ");
                    int s_u_id= in.nextInt();
                    for(int i=1; i<=Student.stdcount; i++){
                        int check_id= std[i].getStdId();
                        String check_name= std[i].getStdName();
                        if(check_id== s_u_id){             
                            System.out.println("Student ID: "+ check_id);
                            System.out.println("Student Name: "+ std[i].getStdName());
                            System.out.println("Student Current CGPA: "+std[i].getStdCGPA());
                            System.out.println("Update Name: ");
                            in.nextLine();
                            String u_name= in.nextLine();
                            System.out.println("Update CGPA: ");
                            double u_cgpa=in.nextDouble();
                            std[i]= new Student(check_id, u_name, u_cgpa);
                            System.out.println("Selected Student Information has been updated...");
                        }
                        else{
                            System.out.println("Student information not found... Try Again!!!");
                        }
                    }
                    
                    break;
                case 2:
                    System.out.println("=================UPDATE COURSE=================");
                    System.out.println("Type Course ID: ");
                    String c_u_id= in.nextLine();
                    for(int i=1; i<=Course.courseCount; i++){
                        String check_c_id= crs[i].getCourseId();
                        if(check_c_id.equals(c_u_id)){
                            int sub_menu;
                            System.out.println("Press 1: Update Course Info");
                            System.out.println("Press 2: Update students/ faculty");
                            sub_menu=in.nextInt();
                            switch(sub_menu){
                                case 1:
                                    System.out.println("================UPDATE COURSE INFO==============");
                                    System.out.println("Course ID: "+ check_c_id);
                                    System.out.println("Course Current Title: "+ crs[i].getCourseTitle());
                                    System.out.println("Course Current Credit Count: "+crs[i].getCourseCredit());
                                    System.out.println("Update Course ID: ");
                                    String new_course_id= in.nextLine();
                                    System.out.println("Update Course Title: ");
                                    String u_c_title= in.nextLine();
                                    System.out.println("Update Course Credit Count: ");
                                    double u_credit= in.nextDouble();
                                    crs[i]= new Course(new_course_id, u_c_title, u_credit);
                                    System.out.println("Selected Course Information has been updated...");
                                    break;
                                case 2:
                                    System.out.println("======UPDATE STUDENTS/ FACULTY FOR A COURSE=======");
                                    boolean p=true;
                                    while(p=true){
                                        int another_sub_menu;
                                        System.out.println("Press 1: Add Faculty");
                                        System.out.println("Press 2: Add Student");
                                        System.out.println("Press 3: Drop Student");
                                        System.out.println("Press 4: Drop Faculty");
                                        System.out.println("Press 5: Print Student List");
                                        another_sub_menu=in.nextInt();
                                        switch(another_sub_menu){
                                            case 1:
                                                System.out.println("=====ADD FACULTY to Course "+ crs[i].getCourseId()+"======");
                                                System.out.println("Faculty ID: ");
                                                int f_id=in.nextInt();
                                                crs[i].addFaculty(fac[f_id]);
                                                System.out.println("Faculty added to this course Successfully");
                                                break;
                                            case 2:
                                                boolean s=true;
                                                while(s=true){
                                                    System.out.println("=====ADD Students to Course "+ crs[i].getCourseId()+"======");
                                                    System.out.println("Student ID: ");
                                                    int s_id=in.nextInt();
                                                    crs[i].addStudent(std[s_id]);
                                                    System.out.println("Selected Student has been added to this course Successfully");
                                                    System.out.println("Add more students? 1=yes / 0=no");
                                                    int choice= in.nextInt();
                                                    if(choice==0){
                                                    break;
                                                    }
                                                }
                                                break;
                                            case 3:
                                                boolean d=true;
                                                while(d=true){
                                                    System.out.println("=====Drop Students from Course "+ crs[i].getCourseId()+"======");
                                                    System.out.println("Student ID: ");
                                                    int s_id=in.nextInt();
                                                    crs[i].dropStudent(s_id);
                                                    System.out.println("Selected Student has been dropped from this course Successfully");
                                                    System.out.println("Drop more students? 1=yes / 0=no");
                                                    int choice= in.nextInt();
                                                    if(choice==0){
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 4:
                                                System.out.println("=====Drop FACULTY from Course "+ crs[i].getCourseId()+"======");
                                                crs[i].dropFaculty();
                                                System.out.println("Faculty dropped from this course Successfully");
                                                break;
                                            case 5:
                                                crs[i].printStudentList();
                                                break;
                                            default:
                                                System.out.println("Wrong input... Try again...");
                                                break;
                                        }
                                        System.out.println("Go back to main menu? 1=yes / 0=no");
                                        int choice= in.nextInt();
                                        if(choice==0){
                                            break;
                                        }
                                        
                                    } 
                            }
                            
                        }
                        else{
                            System.out.println("Course information not found... Try Again!!!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("==============UPDATE FACULTY=============");
                    System.out.println("Type Faculty ID: ");
                    int f_u_id= in.nextInt();
                    for(int i=1; i<=Faculty.facCount; i++){
                        int check_f_id= fac[i].getFacId();
                        if(check_f_id== f_u_id){
                            System.out.println(fac[i].toString());
                            System.out.println("Update Faculty Name: ");
                            in.nextLine();
                            String u_f_name= in.nextLine();
                            System.out.println("Update Faculty Position: ");
                            String u_pos=in.nextLine();
                            fac[i]= null;
                            fac[i]= new Faculty(f_u_id, u_f_name, u_pos);
                            System.out.println("Selected Faculty Information has been updated...");
                        }
                        else{
                            System.out.println("Faculty information not found... Try Again!!!");
                        }
                    }
                    break;
                
                default:
                    System.out.println("Wrong Input!!! Try Again!!");
                    break;    
                }
                break;
            case 4:
                System.out.println("==============PRINT===============");
                System.out.println("Press 1: PRINT ALL STUDENTS");
                System.out.println("Press 2: PRINT ALL COURSES");
                System.out.println("Press 3: PRINT ALL FACULTIES");
                System.out.println("Press 4: PRINT INFORMATION OF A STUDENT");
                System.out.println("Press 5: PRINT INFORMATION OF A COURSE");
                System.out.println("Press 6: PRINT INFORMATION OF A FACULTY");
                System.out.println("Press 7: PRINT STUDENT LIST & FACULTY INFORMATION OF A COURSE");
                System.out.println("Press 8: PRINT COURSES TAKEN BY A STUDENT");
                
                int submenu_4=in.nextInt();
                switch (submenu_4) {
                case 1:
                    System.out.println("============PRINT ALL STUDENTs===========");
                    for(int i=1; i<=Student.stdcount; i++){
                        System.out.println(std[i].toString());
                        System.out.println("");
                    }
                    break;
                case 2:
                    System.out.println("==========PRINT ALL COURSES=============");
                    for(int i=1; i<=Course.courseCount; i++){
                        System.out.println(crs[i].toString()); 
                        System.out.println("");
                    }
                    break;
                case 3:
                    System.out.println("===========PPRINT ALL FACULTIES==========");
                    for(int i=1; i<=Faculty.facCount; i++){
                        System.out.println(fac[i].toString());
                        System.out.println("");
                    }
                    break;
                case 4:
                    System.out.println("======PRINT INFORMATION OF A STUDENT=======");
                    System.out.println("Type Student ID: ");
                    int s_u_id= in.nextInt();
                    for(int i=1; i<=Student.stdcount; i++){
                        int check_id= std[i].getStdId();
                        String check_name= std[i].getStdName();
                        if(check_id== s_u_id){             
                            System.out.println(std[i].toString());
                            
                        }
                        else{
                            System.out.println("Student information not found... Try Again!!!");
                        }
                    }
                    break;
                case 5:
                    System.out.println("=======PRINT INFORMATION OF A COURSE=======");
                    System.out.println("Type Course ID: ");
                    String c_u_id= in.nextLine();
                    for(int i=1; i<=Course.courseCount; i++){
                        String check_c_id= crs[i].getCourseId();
                        if(check_c_id.equals(c_u_id)){
                            System.out.println(crs[i].toString());  
                        }
                        else{
                            System.out.println("Course information not found... Try Again!!!");
                        }
                    }
                    break;
                case 6:
                    System.out.println("========PRINT INFORMATION OF A FACULTY========");
                    System.out.println("Type Faculty ID: ");
                    int f_u_id= in.nextInt();
                    for(int i=1; i<=Faculty.facCount; i++){
                        int check_f_id= fac[i].getFacId();
                        if(check_f_id== f_u_id){
                            System.out.println(fac[i].toString());   
                        }
                        else{
                            System.out.println("Faculty information not found... Try Again!!!");
                        }
                    }
                    break;
                case 7:
                    System.out.println("=====PRINT STUDENT LIST AND FACULTY INFORMATION OF A COURSE=======");
                    System.out.println("Type course ID: ");
                    String c_id=in.nextLine();
                    for(int i=1; i<=Course.courseCount; i++){
                        String check_id= crs[i].getCourseId();
                        if(check_id.equals(c_id)){
                            crs[i].printStudentList();
                        }
                    }
                    break;
                case 8:
                    System.out.println("========PRINT COURSES TAKEN BY A STUDENT==========");
                    System.out.println("Type Student ID: ");
                    int std_id=in.nextInt();
                    for(int i=0; i<=Course.courseCount;i++){
                        boolean check= crs[i].findStd(std_id);
                        if(check==true){
                            System.out.println(crs[i].toString());
                        }
                    }
                    break;
                default:
                    System.out.println("Wrong Input!!! Try Again!!");
                    break;    
                }
                break;
                
            case 5:
                System.out.println("=============SEARCH==============");
                System.out.println("Press 1: Search a Student");
                System.out.println("Press 2: Search a course");
                System.out.println("Press 3: Search a faculty");
                System.out.println("Press 4: Search whether a student takes a course");
                System.out.println("Press 5: Search whether a faculty teaches a course");
                System.out.println("Press 6: Search courses taken by a student");
                System.out.println("Press 7: Search courses taught by a faculty");
                int submenu;
                submenu=in.nextInt();
                switch(submenu){
                    case 1:
                        System.out.println("=======SEARCH A STUDENT========");
                        System.out.println("Type Student ID: ");
                        int s_id= in.nextInt();
                        if(std[s_id]!= null)
                        {
                            System.out.println(std[s_id].toString());
                        }
                        else{
                          System.out.println("Student information was not found!! Try again.");
                        }
                        break;
                    case 2:
                        System.out.println("=========SEARCH A COURSE========");
                        System.out.println("Type Course ID: ");
                        String c_id= in.nextLine();
                        
                        for(int i=1; i<=Course.courseCount; i++){
                        String check_id= crs[i].getCourseId();
                            if(check_id.equals(c_id)){
                                System.out.println(crs[i].toString());
                            }
                            else{
                                System.out.println("Course information not found... Try Again!!! ");
                            }
                        }
                        
                        break;
                    case 3:
                        System.out.println("=======SEARCH A FACULTY========");
                        System.out.println("Type Faculty ID: ");
                        int f_id= in.nextInt();
                        if(fac[f_id]!= null)
                        {
                            System.out.println(fac[f_id].toString());
                        }
                        else{
                          System.out.println("Faculty information was not found!! Try again.");
                        }
                        break;
                    case 4:
                        System.out.println("====SEARCH WHETHER A STUDENT TAKES A COURSE====");
                        System.out.println("Type Student ID: ");
                        int std_id=in.nextInt();
                        for(int i=0; i<=Course.courseCount;i++){
                            boolean check= crs[i].findStd(std_id);
                            if(check==true){
                                System.out.println("This student has taken one or more courses");
                                break;
                            }
                        }
                        System.out.println("This student has not taken any course");
                        break;
                    case 5:
                        System.out.println("====SEARCH WHETHER A FACULTY TEACHES A COURSE====");
                        System.out.println("Type Faculty ID: ");
                        int fac_id=in.nextInt();
                        for(int i=0; i<=Course.courseCount;i++){
                            boolean check= crs[i].findFac(fac_id);
                            if(check==true){
                                System.out.println("This Faculty is teaching one or more courses");
                                break;
                            }
                        }
                        System.out.println("This Faculty is not teaching any course");
                        break;
                    case 6:
                        System.out.println("====SEARCH COURSES TAKEN BY A STUDENT====");
                        System.out.println("Type Student ID: ");
                        int st_id=in.nextInt();
                        in.nextLine();
                        System.out.println("Type Course ID:");
                        String check_c_id= in.nextLine();
                        for(int i=0; i<=Course.courseCount;i++){ 
                            if(check_c_id.equals(crs[i].getCourseId())){
                                boolean checker= crs[i].findStd(st_id);
                                if(checker==true){
                                System.out.println(std[st_id].getStdName()+ " has taken course "+ crs[i].getCourseTitle());
                                break;
                                }
                                else{
                                    System.out.println(std[st_id].getStdName()+ " has not taken course "+ crs[i].getCourseTitle());
                                }
                            
                            }
                        }
                        break;
                    case 7:
                        System.out.println("====SEARCH COURSES TAUGHT BY A FACULTY====");
                        System.out.println("Type Faculty ID: ");
                        int ft_id=in.nextInt();
                        for(int i=0; i<=Course.courseCount;i++){ 
                            boolean checker= crs[i].findFac(ft_id);
                            if(checker==true){
                                System.out.println(fac[ft_id].getFacName()+ " has taken course "+ crs[i].getCourseTitle());
                                }
                        }
                        break;
                    default:
                        break;
                }
                break; 
            default:
                break;
            }
        }
    }
    
}
