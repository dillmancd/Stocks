/*
   File: MakeEmployees.java

   Description: create sample employee data for our database.
   The fields include id, name, age, and salary.

   Date       Author        Changes
   2013-01-28 John Phillips Created
*/

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class MakeEmployees
{
  public static void main(String[] args) throws Exception
  {
    String email = "jphillip@mansfield.edu;marcours10@mounties.mansfield.edu;"
      +"johnsonpd30@mounties.mansfield.edu;donovanea07@mounties.mansfield.edu;"
      +"scottcm20@mounties.mansfield.edu;websterbm08@mounties.mansfield.edu;"
      +"kingjs16@mounties.mansfield.edu;hampsonad19@mounties.mansfield.edu;"
      +"hallrl30@mounties.mansfield.edu;rombergertv13@mounties.mansfield.edu;"
      +"johnsonr15@mounties.mansfield.edu;bowserta08@mounties.mansfield.edu;"
      +"thorwardsonjl01@mounties.mansfield.edu;boltts24@mounties.mansfield.edu;"
      +"ravae20@mounties.mansfield.edu;deitrickpt21@mounties.mansfield.edu;"
      +"fullergr16@mounties.mansfield.edu;klingerjm29@mounties.mansfield.edu;"
      +"hinescm23@mounties.mansfield.edu;brennanmw14@mounties.mansfield.edu;"
      +"singhelrr19@mounties.mansfield.edu;smalleyrm21@mounties.mansfield.edu;"
      +"dillmancd24@mounties.mansfield.edu;riemanjp05@mounties.mansfield.edu;"
      +"kex14@mounties.mansfield.edu;humecr22@mounties.mansfield.edu;"
      +"harrowerla06@mounties.mansfield.edu;uttiok04@mounties.mansfield.edu";
    List<String> emailList = new ArrayList<String>();
    PrintWriter out = new PrintWriter(new BufferedWriter(
        new FileWriter(new File("employeeData.sql"))));

    // Use a regex to parse the email string into names
    Pattern pattern = Pattern.compile("(\\w+?)@.*?;");
    Matcher matcher = pattern.matcher(email);
    for (int i=0; matcher.find(); i++) {
      emailList.add(matcher.group(1));
    }

    // Create an SQL insert statement for each line of employee data
    Random r = new Random();
    for(String name : emailList) {
      String s = "insert into employee (id, name, age, salary)"
        + " values (null, '" + name + "', " + (r.nextInt(80) + 20) + ", "
        + ( (r.nextInt(100000000) + 2000000) / 100.0) + ");\n";
      out.print(s);
    }

    out.close();
  }
}

