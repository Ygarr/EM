<#import "/spring.ftl" as spring />
<h2><@spring.message 'label.title' /></h2>

<form  action="find" method="post"  commandName="employee">
<table>
 <tr>&nbsp;</tr>
 <label for="<@spring.message 'label.findcriteria'/>">
   
    <@spring.message 'label.findcriteria'/>
    </label><input type="text" id="<@spring.message 'label.findcriteria'/>" name="firstname"> 
       
		 <#--Кнопка найти-->
		
			<input type="submit" value="<@spring.message 'label.find'/>" />
				
</table>
</form>
		 <#--Кнопка сброс-->
<form  action="reset" method="post" commandName="employee">
<input type="submit" value="<@spring.message 'label.reset'/>" />
</form>


<#------------------------------------------------------------------------------------>




	<#--------------------------/Кнопка--------------------------->
	
 <td>	
<a href="addnewemployee/"><@spring.message 'label.employeeAddHeader' /></a>
</td>
 <tr>&nbsp;</tr>
<td>
<a href="division/"> <@spring.message 'label.divisionAddHeader' /> </a>
</td> 
<#------------------------------------------------------------------------------------->
	
<#if (employeeList?size>0)>
<table class="data">
        <tr>&nbsp;</tr>
		<tr>
		 	<th><@spring.message 'label.firstname' /></th>
			<th><@spring.message 'label.lastname' /></th>
			<th><@spring.message 'label.birthday' /></th>
			<th>&nbsp;</th>
		</tr>
<#list employeeList as employee>
<tr>
				<td><#t><a href="detail/${employee.id?string.computer}"> ${employee.firstname}</td> 
				<td>${employee.lastname}</td>
				<td>${employee.birthday}</td>
				<td><a href="edit/${employee.id?string.computer}"><@spring.message 'label.edit' /></a></td>
				<form action="delete/${employee.id?string.computer}" method="get">
					<td colspan="2">
					<input type="submit" value="<@spring.message 'label.delete'/>" />
					</td>
				</form>
</tr>				
</#list>
</table>
 <#else> 
<h3 style="color: red;"> <@spring.message 'label.notfound'/> </h3>
</#if>  