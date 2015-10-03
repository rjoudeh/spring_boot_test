<#include "/common.ftl" >
 
<div class="container">
	<div class="page-header">
     <h3>Department's Number of Employees</h3>
   	</div>

	<table class="listTable table table-striped">
			<thead>
		      <tr>
		        <th>Department</th>
		        <th>Number Of Employees</th>
		      </tr>
		    </thead>
		    <tbody>
	        <#list result as res>		
            	<tr>
        			<td>${res.name}</td>
        			<td>${res.getEmployeesCount()}</td>
         		</tr>
     		</#list> 
     		</tbody>  	
		</table>		
<#include "footer.ftl" >
</div>
