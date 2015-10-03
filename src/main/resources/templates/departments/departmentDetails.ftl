<#include "/common.ftl" >
 

<div class="container">
	<div class="page-header">
     <h3>Department</h3>
   	</div>
   	
   	<#if successMessage?has_content>
	   <div class="alert alert-success">
		  <strong>${successMessage}</strong> 
	   </div>
    </#if>
   
     <div class="control-group">  
       
        <form name="department" action="add" method="post">
            
            
            <div class="form-group">
                <label class="control-label" for="name">Name </label>            
                <input type="text" class="form-control" name="name">
             </div>
             
             <div class="form-group">
                 <label class="control-label" for="salary">Location </label>
           	     <input type="text" class="form-control" name="location">
             </div>
            
             <div class="form-group">
                 <label class="control-label" for="maritalStatus">Manager </label>
                <input type="text" class="form-control" name="manager">
             </div>
             
              <div class="form-group">
                <input type="submit" class="btn btn-primary">
            </div>
            
        </form>
     </div>
<div>

<#include "/footer.ftl" >