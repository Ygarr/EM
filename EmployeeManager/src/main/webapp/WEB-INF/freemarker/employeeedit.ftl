<#import "/spring.ftl" as spring />
 
<h2><@spring.message 'label.title' /></h2>
<#setting number_format="currency">
<#--------------------------------------------------------------------------------------------------->
<#-------------------Вывод данных в поля для редактирования и для ввода------------------------------>
<br/>  

<#setting locale="en_US">

<#if (employee.active?string("1","0")="1")>


<form  action="<@spring.url '/updated'/>" method="post">	
	
	<label for="<@spring.message 'label.id'/>">
    <@spring.message 'label.id'/>
    </label><input type="text" id="<@spring.message 'label.id'/>" name="id" value="${employee.id?string.computer}" READONLY><br/>
	
	<label for="<@spring.message 'label.firstname'/>">
		<@spring.message 'label.firstname'/>
    </label>
    <input type="text" id="<@spring.message 'label.firstname'/>" name="firstname" value="${employee.firstname?capitalize}"><br/>
	<#--валидация, ошибки красным цветом-->
		<@spring.bind "employee.firstname" />
		<font color="red">
		<@spring.showErrors "<br>" />
    </font> </br>
    
    <label for="<@spring.message 'label.lastname'/>">
        <@spring.message 'label.lastname'/>
    </label>
    <input type="text" id="<@spring.message 'label.lastname'/>" name="lastname" value="${employee.lastname?capitalize}"><br/>
		<#--валидация, ошибки красным цветом-->
		<@spring.bind "employee.lastname" />
		<font color="red">
		<@spring.showErrors "<br>" />
	</font></br>
	
	<label for="<@spring.message 'label.salary'/>">
	<@spring.message 'label.salary'/>
    </label><input type="text" id="<@spring.message 'label.salary'/>" name="salary" value="${employee.salary?string("0.00")}"><br/>
   <#--валидация, ошибки красным цветом-->
   <#setting number_format="#####.##"><#--Формат зарплаты-->	
   	 	<@spring.bind "employee.salary" />
		<font color="red">
		<@spring.showErrors "<br>" />
	</font></br>
   
	<label for="<@spring.message 'label.birthday'/>">
   	 	<@spring.message 'label.birthday'/>
    </label>
    <input type="text" id="<@spring.message 'label.birthday'/>" name = "birthday" value = ${employee.birthday?string("yyyy-MM-dd")}><br/>
    <#--валидация, ошибки красным цветом-->
    	<@spring.bind "employee.birthday" />
		<font color="red">
		<@spring.showErrors "<br>" />
		</font></br>
	 	
    <label for="<@spring.message 'label.active'/>">
    	<@spring.message 'label.active'/>
    </label><input type="text" id="<@spring.message 'label.active'/>" name="active" value="${employee.active?string("1","0")}"><br/>
   <#--валидация, ошибки красным цветом-->
    <@spring.bind "employee.active" />
	<font color="red">
		<@spring.showErrors "<br>" />
		</font>
    </br>
			
	<label for="<@spring.message 'label.division'/>">
	<#setting number_format="number"><#--Формат номера отдела-->	
   		 <@spring.message 'label.division'/>
    </label><input type="text" id="<@spring.message 'label.division'/>" name="division.id" value="${employee.division.id}"><br/>	<#-- -->
 	
<br/> 




<#--Кнопка сохранить-->
<table>
	<tr>
		<th>
				<td colspan="2">
					<input type="submit" value="<@spring.message code="label.update"/>" />
				</td>
		</form>
	 	</th>
<#--/Кнопка  отменить-->	 	
	 	<th>
		<form action="<@spring.url '/index'/>" method="post"  commandName="employee">
				 <td colspan="2">
						<input type="submit" value="<@spring.message code="label.cancel"/>" />
				 </td>
		</form>
		</th>
	</tr>
</table>

	<#--Кнопка/-->
	
	
	 <#else> <#------------------------------------------ИНАЧЕ------------------------------------------------------------------->
	 

<form  action="<@spring.url '/updated'/>" method="post">	
	
	<label for="<@spring.message 'label.id'/>">
    <@spring.message 'label.id'/>
    </label><input type="text" id="<@spring.message 'label.id'/>" name="id" value="${employee.id?string.computer}" DISABLED><br/>
	
	<label for="<@spring.message 'label.firstname'/>">
		<@spring.message 'label.firstname'/>
    </label>
    <input type="text" id="<@spring.message 'label.firstname'/>" name="firstname" value="${employee.firstname}" DISABLED><br/>
	<@spring.bind "employee.firstname" />
	<font color="red">
	<@spring.showErrors "<br>" />
    </font> </br>
    
    <label for="<@spring.message 'label.lastname'/>">
        <@spring.message 'label.lastname'/>
    </label>
    <input type="text" id="<@spring.message 'label.lastname'/>" name="lastname" value="${employee.lastname}" DISABLED><br/>
	<@spring.bind "employee.lastname" />
	<font color="red">
		<@spring.showErrors "<br>" />
	</font></br>
	
	<label for="<@spring.message 'label.salary'/>">
   <#setting number_format="currency"><#--Формат зарплаты-->
    <@spring.message 'label.salary'/>
    </label><input type="text" id="<@spring.message 'label.salary'/>" name="salary" value="${employee.salary?string("0.00")}" DISABLED><br/>
    <@spring.bind "employee.salary" />
	<font color="red">
		<@spring.showErrors "<br>" />
	</font>
    </br>
   
	 <label for="<@spring.message 'label.birthday'/>">
   	 	<@spring.message 'label.birthday'/>
    </label>
    <input type="text" id="<@spring.message 'label.birthday'/>" name = "birthday" value = ${employee.birthday?string("yyyy-MM-dd")} DISABLED><br/>
     <@spring.bind "employee.birthday" />
	<font color="red">
		<@spring.showErrors "<br>" />
		</font>
    </br>
	 	
    <label for="<@spring.message 'label.active'/>">
    	<@spring.message 'label.active'/>
    </label><input type="text" id="<@spring.message 'label.active'/>" name="active" value="${employee.active?string("1","0")}" DISABLED><br/>
    <@spring.bind "employee.active" />
	<font color="red">
		<@spring.showErrors "<br>" />
		</font>
    </br>
			
	<label for="<@spring.message 'label.division'/>">
	<#setting number_format="number"><#--Формат зарплаты-->
   		 <@spring.message 'label.division'/>
    </label><input type="text" id="<@spring.message 'label.division'/>" name="division.id" value="${employee.division.id}" DISABLED><br/>	<#-- -->
 	
<br/> 




<#--Кнопка сохранить-->
<table>
	<tr>
		<th>
		
				<td colspan="2">
					<input type="submit" value="<@spring.message code="label.update"/>" />
				</td>
		</form>
	 	</th>
<#--/Кнопка  отменить-->	 	
	 	<th>
		<form action="<@spring.url '/index'/>" method="post"  commandName="employee">
				 <td colspan="2">
						<input type="submit" value="<@spring.message code="label.cancel"/>" />
				 </td>
		</form>
		</th>
	</tr>
</table>

	<#--Кнопка/-->
	</#if>	 
	
	
	