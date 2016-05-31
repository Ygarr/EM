<#import "/spring.ftl" as spring />
<h2><@spring.message 'label.title' /></h2>
<br/> 

<form  action="add" method="post" commandName="addnewdivision">


<table>
	<label for="<@spring.message 'label.id'/>">
    	<@spring.message 'label.id'/>
    	<br>
    </label><input type="text" id="<@spring.message 'label.id'/>" name="id" READONLY><br/>
    
	
			
	<label for="<@spring.message 'label.division'/>">
   		<@spring.message 'label.division'/>
   		<br>
    </label><input type="text" id="<@spring.message 'label.division'/>" name="NAME">
    <#--валидация, ошибки красным цветом-->
    	<@spring.bind "division.NAME" />
		<font color="red">
		<@spring.showErrors "<br>" />
    	</font><br/>	
		
		
	
		<tr>
			<td colspan="2">
				<input type="submit" value="<@spring.message code="label.adddivision"/>" />
			</td>
	   </tr>
</table>
	 
	</form>
	<#--/Кнопка  отменить-->	 	
	 	<th>
		<form action="<@spring.url '/division/'/>" method="post"  commandName="addnewdivision">
				 <td colspan="2">
						<input type="submit" value="<@spring.message code="label.cancel"/>" />
				 </td>
		</th>
		</form>
