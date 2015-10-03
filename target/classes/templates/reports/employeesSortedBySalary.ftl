<#include "/common.ftl" >
 
<div class="container">
	<div class="page-header">
     <h3>Employees Sorted by salary</h3>
   	</div>

	<table class="listTable table table-striped">
			<thead>
		      <tr>
		        <th>Employee name</th>
		        <th>Department</th>
		        <th>Salary</th>
		      </tr>
		    </thead>
		    <tbody>
	        <#list employees as emp>		
            	<tr>
        			<td>${emp.name}</td>
        			<#assign dep = "N/A" >
        			<#if emp.department?has_content>
        				<#assign dep = emp.department.name >        			
        			</#if>
        			<td>${dep}</td>
        			<td>${emp.getFormatedSalary()}</td>
         		</tr>
     		</#list> 
     		</tbody>  	
		</table>		
<#include "footer.ftl" >
</div>
