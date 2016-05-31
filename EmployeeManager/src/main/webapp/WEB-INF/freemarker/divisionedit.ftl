<#import "/spring.ftl" as spring />
 
<h2><@spring.message 'label.title' /></h2>
<#setting number_format="currency">
<#--------------------------------------------------------------------------------------------------->
<#-------------------Вывод данных в поля для редактирования и для ввода------------------------------>
<br/>  




<form  action="<@spring.url '/divisionupdated'/>" method="post">	
	
	<label for="<@spring.message 'label.id'/>">
    <@spring.message 'label.id'/>
    </label><input type="text" id="<@spring.message 'label.id'/>" name="id" value="${division.id?string.computer}" READONLY><br/>
	
	<label for="<@spring.message 'label.division'/>">
		<@spring.message 'label.division'/>
    </label>
    <input type="text" id="<@spring.message 'label.division'/>" name="NAME" value="${division.NAME?capitalize}"><br/>
	  
<br/> 




<#--Кнопка сохранить-->
<table>
	<tr>
		<th>
				<td colspan="2">
					<input type="submit" value="<@spring.message code="label.update"/>" />
				</td>
		</form>
			<form action="<@spring.url '/division/'/>" method="post"  commandName="division">
				 <td colspan="2">
						<input type="submit" value="<@spring.message code="label.cancel"/>" />
				 </td>
		</form>
		</th>
	</tr>
	</form>
	 	</th>
<#--/Кнопка  отменить-->	 	
	 	<th>
	
</table>

	<#--Кнопка/-->