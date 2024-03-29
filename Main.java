import java.util.Scanner;

class Main 
{
    public static void main(String[] args) 
    {
        Department department = new Department("Computer Science");
        Scanner input = new Scanner(System.in);

        boolean condition = true;

        while (condition) 
        {
            // Display menu graphics
            System.out.println("===========================================");
            System.out.println("|               MENU SELECTION            |");
            System.out.println("===========================================");
            System.out.println("| Options:                                |");
            System.out.println("|        1. Manage Department             |");
            System.out.println("|        2. Student portal                |");
            System.out.println("|        3. Teachers portal               |");
            System.out.println("|        4. Exit                          |");
            System.out.println("===========================================");
            System.out.print("Select option: ");
            int selection = input.nextInt();
            switch (selection) 
            {
                case 1:
                    manageDepartment(department);
                    break;
                case 2:
                    studentPortal(department);
                    break;
                case 3:
                    teacherPortal(department);
                    break;
                case 4:
                    System.out.println("Exit selected");
                    condition = false;
                    return;
                default:
                    System.out.println("Invalid selection");
                    break; // This break is not really necessary
            }
        }
        input.close();
    }

    static void manageDepartment(Department department)
    {
        Scanner input = new Scanner(System.in);
        boolean condition = true;
        while (condition) 
        {
            System.out.println("Department Name: " + department.Name);
            System.out.println("===========================================");
            System.out.println("|               MENU SELECTION            |");
            System.out.println("===========================================");
            System.out.println("| Options:                                |");
            System.out.println("|        1. Manage Teachers               |");
            System.out.println("|        2. Manage Students               |");
            System.out.println("|        3. Manage Courses                |");
            System.out.println("|        4. Exit                          |");
            System.out.println("===========================================");
            System.out.print("Select option: ");
            int selection = input.nextInt();
            switch (selection) 
            {
                case 1:
                    department.departmentTeacherManagment();
                    break;
                case 2:
                    department.manageStudents();
                    break;
                case 3:
                    department.manageCourse();
                    break;
                case 4:
                    System.out.println("Exit selected");
                    condition = false;
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        }
        input.close();
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static void studentPortal(Department department)
    {
        boolean condition = true;
        while (condition) 
        {
            switch (LoginMenu()) 
            {
                case 1:
                    studentogin(department);
                    break;
                case 2:
                    System.out.println("Exit selected");
                    condition = false;
                    break;
                default:
                    System.out.println("Invalid selection \nPlease try again");
            }
        }
    }

    static void studentogin(Department department)
    {
        System.out.println("Enter your name: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("Enter your password: ");
        String password = input.nextLine();

        for(Student student : department.students)
        {
            if(student.name.equals(name) && student.password.equals(password))
            {
                student.studentPortal(department);
                input.close();
                return;
            }
        }
        System.out.println("Invalid credentials\nTry Again");
        input.close();
    }
////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

    static void teacherPortal(Department department)
    {
        boolean condition = true;
        while (condition) 
        {
            switch (LoginMenu())
            {
                case 1:
                    teacherLogin(department);
                    break;
                case 2:
                    System.out.println("Exit selected");
                    condition = false;
                    break;
                default:
                    System.out.println("Invalid selection \nPlease try again");
            }
        }
    }

    static void teacherLogin(Department department)
    {
        System.out.println("Enter your name: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("Enter your password: ");
        String password = input.nextLine();

        for(Teacher teacher : department.teachers)
        {
            if(teacher.name.equals(name) && teacher.password.equals(password))
            {
                teacher.teacherPortal(department);
                input.close();
                return;
            }
        }
        System.out.println("Invalid credentials");
        input.close();
    }

////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////

    static int LoginMenu()
    {
        Scanner input = new Scanner(System.in);
        // Display menu graphics
        System.out.println("===========================================");
        System.out.println("|               MENU SELECTION            |");
        System.out.println("===========================================");
        System.out.println("| Options:                                |");
        System.out.println("|        1. Login                         |");
        System.out.println("|        2. Exit                          |");
        System.out.println("===========================================");
        System.out.print("Select option: ");
        int choice = input.nextInt();
        input.close();
        return choice;
    }
}
