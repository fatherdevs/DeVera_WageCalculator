package mcm.edu.ph.devera_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

//Wage Calculator

//Regular Employee:
//1-8 hours(regular work time):100 pesos per hour
//Probationary Employee:
//1-8 hours: 90 pesos per hour
//Part-time workers:
// 1-8 hours: 75 pesos per hour


public class Display extends AppCompatActivity {

    TextView txtName, txtType, txtHours, txtWage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        txtName = findViewById(R.id.txtEmployeeName);
        txtType = findViewById(R.id.txtEmployeeType);
        txtHours = findViewById(R.id.employeeHours);
        txtWage = findViewById(R.id.txtTotalWage);


        Intent i = getIntent();

        String EmployeeType = i.getStringExtra("type");
        String EmployeeName = i.getStringExtra("empName");
        Double EmployeeHours = Double.parseDouble(i.getStringExtra("hours"));


        txtName.setText("Employee Name: " + EmployeeName);
        txtName.setText("Employee Type: " + String.valueOf(EmployeeType));
        txtType.setText("Hours Rendered: " + String.valueOf(EmployeeHours));

        calcWage(EmployeeType, EmployeeHours, txtWage);

    }

    //Method
    public void calcWage(String employeeType, Double employeeHours, TextView txtWage) {
        Double totalWage = 0.0;
        //overtime solution
        if (employeeHours > 8.0) {
            if (employeeType.equals("Full-time")){
                totalWage = 800 + (115 * (employeeHours - 8.0));
                txtWage.setText("Total Wage with Overtime: ₱" + String.valueOf(totalWage));
            }
            else if (employeeType.equals("Part-time")){
                totalWage = 600 + (90 * (employeeHours -8.0));
                txtWage.setText("Total Wage with Overtime: ₱" + String.valueOf(totalWage));
            }
            if (employeeType.equals("Probationary")){
                totalWage = 720 + (100 * (employeeHours - 8.0));
                txtWage.setText("Total Wage with Overtime: ₱" + String.valueOf(totalWage));
            }
        }
        //Wage solution w/out overtime
        else {
            if (employeeType.equals("Full-time")) {
                totalWage = employeeHours * 100;
                txtWage.setText("Total Wage: ₱" + String.valueOf(totalWage));
            } else if (employeeType.equals("Part-time")) {
                totalWage = employeeHours * 75;
                txtWage.setText("Total Wage: ₱" + String.valueOf(totalWage));
            } else {
                totalWage = employeeHours * 90;
                txtWage.setText("Total Wage: ₱" + String.valueOf(totalWage));
            }
        }
    }
}