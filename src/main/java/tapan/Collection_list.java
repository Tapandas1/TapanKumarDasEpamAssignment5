package tapan;
import java.util.Scanner;

import java.util.ArrayList;
class Employee
{
	private String EmployeeName;
	private int EmployeeID;
	private double EmployeeSalary;
	private String EmployeeDept;
	Employee()
	{
	EmployeeName="Raja Mohan";
	EmployeeID=1;
	EmployeeSalary=10000;
	EmployeeDept="Devolpment";
	}
	Employee(String EmployeeName , int EmployeeID ,double EmployeeSalary, String EmployeeDept)
	{
		this.EmployeeName=EmployeeName;
		this.EmployeeID=EmployeeID;
		this.EmployeeSalary=EmployeeSalary;
		this.EmployeeDept=EmployeeDept;
	}
	public int getEmployeeID()
	{
		return EmployeeID;
	}
	static Employee employeeFetchRecord(int EmployeeID,ArrayList<Employee>employee)
	{
		Employee T=null;
		if(employee.isEmpty()==true)
		{
			System.out.println("Record Empty");
		}
		boolean flag=false;
		for(Employee E:employee)
		{
			if(E.getEmployeeID()==EmployeeID)
			{
				flag=true;
				T=E;
				break;
			}
		}
		if(flag==false)
		{
			System.out.println("No Records available matching the ID");
		}
		return T;
	}
	static void employeeInsertRecord(Employee employee,ArrayList<Employee>employees)
	{
		boolean flag=false;
		Employee employeeReference=null ;
		for(Employee E:employees)
		{
			if(E.getEmployeeID()==employee.getEmployeeID()) 
			{
				flag=true;
				employeeReference=E;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("Record Already Exist");
			employeeDisplaySpecificRecord(employeeReference);
		}
		else
		{
			employees.add(employee);
			System.out.println(" New Record Added Sucessfully");
		}
	}
	static void employeeDeleteRecord(int EmployeeID,ArrayList<Employee>employees)
	{
		Employee E=employeeFetchRecord(EmployeeID,employees);
		if(E==null)
		return;
		System.out.println(" Record Deleted Successfully");
		employees.remove(E);
	}
	static void employeeDisplayRecord(ArrayList<Employee>employees)
	{
		if(employees.isEmpty()==true)
		{
		System.out.println("No Records present");
		return;
		}
		for(Employee E:employees)
		{
			employeeDisplaySpecificRecord(E);
			System.out.println();
		}
	}
	static void employeeDisplaySpecificRecord(Employee employee)
	{
			if(employee==null) 
			{
				System.out.println("No record present");
				return;
			}
			System.out.println(" ID    :"+employee.EmployeeID);
			System.out.println(" Name   :"+employee.EmployeeName);
			System.out.println(" Salary :"+employee.EmployeeSalary);
			System.out.println(" Dept  :"+employee.EmployeeDept);
		}
	public boolean equals(Object obj) {
	    if (obj instanceof Employee) {
	        Employee E = (Employee) obj;
	        return E.EmployeeID == this.EmployeeID;
	    }
	    return false;
	}
	}

public class Collection_list {

    public static void main( String[] args )
    {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        Scanner scanner = new Scanner(System.in);
        employees.add(new Employee("Akash Das",2,40000,"Developer"));
        employees.add(new Employee("Amit Kumar",3,30000,"Programmer"));
        employees.add(new Employee("Trideep Chakraborty",7,35000,"Accountant"));
        employees.add(new Employee("Amarjeet Gupta",4,40000,"Developer"));
        employees.add(new Employee("Tapan Kumar Das",5,20000,"Programmer"));
        employees.add(new Employee("Sayan Maity",8,45000,"Maintainance"));
        employees.add(new Employee("Himanshu Surana",10,90000,"Developer"));
        employees.add(new Employee("Chiraag Mishra",9,45000,"Maintainance"));
        employees.add(new Employee("Rahul Sinha",6,30000,"Testing"));
        employees.add(new Employee("Kaustav Guha",11,50000,"Testing"));
        int choice,employeeID;
        double employeeSalary;
        char choice1;
        String employeeName,employeeDept;
        do
        {
        	System.out.println("-----EPAM ASSIGNMENT 5------");
        	System.out.println("1.Insert Records");
        	System.out.println("2.Display Records");
        	System.out.println("3.Delete Records");
        	System.out.println("4.Fetch Records");
        	System.out.println("Enter your choice");
        	choice=scanner.nextInt();
        	switch(choice)
        	{
        	case 1:System.out.println("Enter the employee Name");
        		   scanner.nextLine();
        		   employeeName=scanner.nextLine();
        		   System.out.println("Enter the employee ID");
        		   employeeID=scanner.nextInt();
        		   System.out.println("Enter the employee salary");
        		   employeeSalary=scanner.nextDouble();
        		   scanner.nextLine();
        		   System.out.println("Enter the employee department");
        		   employeeDept=scanner.nextLine();
        		   Employee.employeeInsertRecord(new Employee(employeeName,employeeID,employeeSalary,employeeDept),employees);
        		   break;
        	case 2:Employee.employeeDisplayRecord(employees);
        	       break;
        	case 3:System.out.println("Enter the employee ID");
        		   employeeID=scanner.nextInt();
        		  Employee. employeeDeleteRecord(employeeID, employees);
        		   break;
        	case 4:System.out.println("Enter the the employee ID ");
        	       employeeID =scanner.nextInt();
 		           Employee E=Employee.employeeFetchRecord(employeeID,employees);
 		           Employee.employeeDisplaySpecificRecord(E);
 		           break;
 		    default:System.out.println("Wrong Choice");
        	}
        	System.out.println("Do you want to continue(y/n)");
        	 choice1=scanner.next().charAt(0);
        	 scanner.nextLine();
        }while(choice1=='y');
        scanner.close();
    }
}


