<#import "/spring.ftl" as spring />
<h2><@spring.message 'label.title' /></h2>



<form  action="find" method="post"  commandName="employee">
<table>
 <tr>&nbsp;</tr>
 <label for="<@spring.message 'label.firstname'/>">
    <@spring.message 'label.firstname'/>
    </label><input type="text" id="<@spring.message 'label.firstname'/>" name="firstname"><br/>
    
    <label for="<@spring.message 'label.lastname'/>">
    <@spring.message 'label.lastname'/>
    </label><input type="text" id="<@spring.message 'label.lastname'/>" name="lastname"><br/>
  <tr><#--Кнопка найти-->
		
				<td colspan="2">
					<input type="submit" value="<@spring.message 'label.find'/>" />
				</td>
	<tr>&nbsp;</tr>	
	   </tr>
	  </table>
	</form>





<#-------------------------------------------------------------------------------->

<a href="<@spring.url '/login.jsp'/> ">
	<@spring.message 'label.logout' />
</a>
  


<#--form:form method="post" action="add" commandName="employee"-->
    <form  action="add" method="post" commandName="employees">

		<table>
	<label for="<@spring.message 'label.firstname'/>">
    <@spring.message 'label.firstname'/>
    </label><input type="text" id="<@spring.message 'label.firstname'/>" name="firstname"><br/>
    
    <label for="<@spring.message 'label.lastname'/>">
    <@spring.message 'label.lastname'/>
    </label><input type="text" id="<@spring.message 'label.lastname'/>" name="lastname"><br/>
	
	<label for="<@spring.message 'label.salary'/>">
    <@spring.message 'label.salary'/>
    </label><input type="text" id="<@spring.message 'label.salary'/>" name="salary"><br/>
    
    <label for="<@spring.message 'label.birthday'/>">
    <@spring.message 'label.birthday'/>
    </label><input type="text" id="<@spring.message 'label.birthday'/>" name="birthday"><br/>
	
    <label for="<@spring.message 'label.active'/>">
    <@spring.message 'label.active'/>
    </label><input type="text" id="<@spring.message 'label.active'/>" name="active"><br/>
			
	<label for="<@spring.message 'label.division'/>">
    <@spring.message 'label.division'/>
    </label><input type="text" id="<@spring.message 'label.division'/>" name="division"><br/>	
		
		
	
<br/><tr><#--Кнопка добавить-->

			
		
				<td colspan="2">
					<input type="submit" value="<@spring.message code="label.addemployee"/>" />
				</td>
			
	   </tr>
	  </table>
	</form>
	<#--Кнопка/-->



<#-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
<h3><@spring.message 'label.employees' /></h3>


<#if (employeeList?size>0)>
	<table class="data">
		<tr>
			<th><@spring.message 'label.id' /></th>
			<th><@spring.message 'label.firstname' /></th>
			<th><@spring.message 'label.birthday' /></th>
			<th><@spring.message 'label.salary' /></th>
			<th><@spring.message 'label.active' /></th>
			<th><@spring.message 'label.division' /></th>
			<th>&nbsp;</th>
	   </tr>
		<#list  employeeList as employee>
			<tr>
				<td>${employee.id}</td>
				<td>${employee.lastname}, ${employee.firstname}</td>
				<td>${employee.birthday}</td>
				<td>${employee.salary}</td>
				<td>${employee.active?string("true","false")}</td><#--boolean-->
				<td>${employee.division}</td>
				
				<form action="delete/${employee.id}" method="get">
					<td colspan="2">
					<input type="submit" value="<@spring.message 'label.delete'/>" />
					</td>
				</form>
				</tr>
	</#list>
</table>
</#if>