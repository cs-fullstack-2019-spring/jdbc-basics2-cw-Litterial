import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {


    private final static String url = "jdbc:postgresql://localhost:5432/2019-05-20-cw-am";
    private final static String user = "student";
    private final  static String password = "C0d3Cr3w";

    public static java.sql.Connection connect() {
        java.sql.Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = java.sql.DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            System.out.println("\n");
            ex1(conn);
            System.out.println("\n");
            ex2(conn);
            System.out.println("\n");
            ex3(conn);
            System.out.println("\n");
            ex4(conn);
            System.out.println("\n");
            ex5(conn);
            System.out.println("\n");
            ex6(conn);
            System.out.println("\n");
            ex7(conn);
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
//    1. Create a new Los Angeles entry for Papers with any code that cost 90.1.
    public static void ex1(Connection conn) {
//        String SQL = "Insert into Boxes(Code,Contents,Value,Warehouse) Values('L33T','Paper',90.1,2)";
        String SQL = "Select * from Boxes";
       try {
           PreparedStatement pstmt = conn.prepareStatement(SQL);
           ResultSet rs = pstmt.executeQuery();
           while (rs.next()) {
               //returns element at column index
               System.out.println(rs.getString(1) + ","
                       + rs.getString(2) + ","+rs.getString(3) + ","+rs.getString(4));
           }
       }

        catch(SQLException ex)
           {
               System.out.println(ex.getMessage());
           }

        }
    //2. Select the warehouse code and the average value of the boxes in each warehouse.
    public static void ex2(Connection conn) {
        String SQL = "Select warehouse, avg(value) as average_value from Boxes group by warehouse order by warehouse asc ";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + ","
                        + rs.getString(2));
            }
        }

        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
//3. Select the warehouse code and the average value of the boxes in each warehouse, but select only those warehouses where the average value of the boxes is greater than 150.

    public static void ex3(Connection conn) {
        String SQL = "Select warehouse, avg(value) as average_value from Boxes  group by warehouse having avg(value)>150 order by warehouse asc";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + ","
                        + rs.getString(2));
            }
        }

        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    //4. Find all values per each content in the Boxes table.

    public static void ex4(Connection conn) {
        String SQL = "Select warehouse, sum(value) as average_value from Boxes group by warehouse order by warehouse asc";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + ","
                        + rs.getString(2));
            }
        }

        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
//    5. Find the total value of all boxes.

    public static void ex5(Connection conn) {
        String SQL = "Select sum(value) as sum_value from Boxes";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        }

        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
//    6. Reduce the value of all boxes by 15%.
    public static void ex6(Connection conn) {
//        String SQL = "Update  Boxes set value = value*.85";
        String SQL = "Select * from Boxes";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + ","
                        + rs.getString(2) + ","+rs.getString(3) + ","+rs.getString(4));
            }
        }

        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
//    7. Remove all boxes with a value lower than $100.
    public static void ex7(Connection conn) {
//        String SQL = "Delete from Boxes where value< 100";
        String SQL = "Select * from Boxes";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + ","
                        + rs.getString(2) + ","+rs.getString(3) + ","+rs.getString(4));
            }
        }

        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    public static void main(String[] args) {
        connect();

    }
}
