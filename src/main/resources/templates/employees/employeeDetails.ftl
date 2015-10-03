 <#include "/common.ftl" >
 
<div class="container">
	<div class="page-header">
     <h3>Employee</h3>
   </div>
   
   <#if successMessage?has_content>
	   <div class="alert alert-success">
		  <strong>${successMessage}</strong> 
	   </div>
   </#if>
   
   
     <div class="control-group">
        <form name="employee" action="add" method="post">
            
            <div class="form-group">
                <label class="control-label" for="name">Name </label>       
                <input type="text" class="form-control" name="name">
             </div>
             
             <div class="form-group">
                <label class="control-label" for="salary">Salary </label>           
                <input type="text" class="form-control" name="salary">
             </div>
             

             <div class="form-group">
             	 <label class="control-label" for="salary">Birth date </label>     
                 <input type='date' class="form-control" name="birthDate" />                   
             </div>
            
             <div class="form-group">
                 <label class="control-label" for="maritalStatus">Status </label>         
                <input type="text" class="form-control" name="maritalStatus">
             </div>
			
			<div class="form-group">
				 <select class="form-control" name="department.departmentId">
	                <option value="">--Department--</option>
	                <#list deps as dep>
	                  <option value="${dep.departmentId}">${dep.name?if_exists}</option>
	                </#list>
	             </select>          
             </div>
             
             <div class="form-group">
                <input type="submit" class="btn btn-primary">
            </div>
            
        </form>
     </div>
<div>


<#include "/footer.ftl" >