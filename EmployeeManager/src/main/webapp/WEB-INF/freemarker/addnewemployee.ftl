<#import "/spring.ftl" as spring />

<#--Кнопка добавления нового сотрудника-->
<#setting locale="en_US">
<form  action="add" method="post" commandName="employees">

		<table>
	<label for="<@spring.message 'label.firstname'/>">
    <@spring.message 'label.firstname'/>
    <br>
    </label><input type="text" id="<@spring.message 'label.firstname'/>" name="firstname">
    </br>
    <#--валидация, ошибки красным цветом-->
    	<@spring.bind "employee.firstname" />
		<font color="red">
		<@spring.showErrors "<br>" />
		</font>
    </br>
    
    <label for="<@spring.message 'label.lastname'/>">
    <@spring.message 'label.lastname'/>
    <br>
    </label><input type="text" id="<@spring.message 'label.lastname'/>" name="lastname">
    <br/>
    <#--валидация, ошибки красным цветом-->
		<@spring.bind "employee.lastname" />
		<font color="red">
		<@spring.showErrors "<br>" />
		</font>
    </br>
	
	<label for="<@spring.message 'label.salary'/>">
    <@spring.message 'label.salary'/>
    <@spring.message 'label.salaryformat' />
    <br>
    </label><input type="text" id="<@spring.message 'label.salary'/>" name="salary">
    <br/>
    <#--валидация, ошибки красным цветом-->
		<@spring.bind "employee.salary" />
		<font color="red">
		<@spring.showErrors "<br>" />
		</font>
    </br>
    
    <label for="<@spring.message 'label.birthday'/>">
    <@spring.message 'label.birthday'/>
    <@spring.message 'label.dateformat' /> 
    <br>
    </label><input type="text" id="<@spring.message 'label.birthday'/>" name="birthday">
    <br/>
    <#--валидация, ошибки красным цветом-->
		<@spring.bind "employee.birthday" />
		<font color="red">
		<@spring.showErrors "<br>" />
		</font>
    </br>
	
   
			
	<label for="<@spring.message 'label.division'/>">
	<@spring.message 'label.division'/>
	<br>
    </label><input type="text" id="<@spring.message 'label.division'/>" name="division.id"><br/>
    	
		
		
	
<br/><tr><#--Кнопка добавить-->

			
		
				<td colspan="2">
					<input type="submit" value="<@spring.message code="label.addemployee"/>" />
				</td>
			
	   </tr>
	  </table>
	  
	  
	</tr>
	  
	</form>
		<#--/Кнопка  отменить-->	 	
	 	<th>
		<form action="<@spring.url '/index'/>" method="post"  commandName="division">
				 <td colspan="2">
						<input type="submit" value="<@spring.message code="label.cancel"/>" />
				 </td>
		</th>
		</form>

