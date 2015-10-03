<#include "/common.ftl" >
 
<div class="container">
	<div class="page-header">
     <h3>Department Details</h3>
   	</div>

	<table class="listTable table table-striped">
			<thead>
		      <tr>
		        <th>Department</th>
		        <th>Manager name</th>
		        <th>Number Of Employees</th>
		        <th>Total Salary</th>
		      </tr>
		    </thead>
		    <tbody>
	        <#list result as res>		
            	<tr>
        			<td>${res.name}</td>        			
        			<td>${res.manager?default("N/A")}</td>
        			<td>${res.getEmployeesCount()}</td>
        			<td>${res.getFormatedTotalSalary()}</td>
         		</tr>
     		</#list> 
     		</tbody>  	
		</table>		
<#include "footer.ftl" >
</div>
