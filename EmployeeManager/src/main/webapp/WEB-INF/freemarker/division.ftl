<#import "/spring.ftl" as spring />
<h2><@spring.message 'label.title' /></h2>
<br/>  





<form  action="addnewdivision/" method="post" commandName="addnewdivision">
	<td colspan="2">
					<input type="submit" value="<@spring.message code="label.adddivision"/>" />
				</td>
	   </tr>
</form>
	 
	 
<#------------------------------------------------------------------------------------->
	
<#if (divisionList?size>0)>
<table class="data">
      
		<tr>
			<tr>&nbsp;</tr>
		 	<th><@spring.message 'label.id' /></th>
			<th><@spring.message 'label.division' /></th>
		</tr>
<#list divisionList as division>
<tr>				
				<td>${division.id}</td>
				<td>${division.NAME}</td>
				<form action="dedit/${division.id?string.computer}" method="get">
					<td colspan="2">
					<input type="submit" value="<@spring.message 'label.edit'/>" />
					</td>
				</form>
				</form>
			
		</form>
				
</tr>				
</#list>
</table>
</#if>
</br>
</br>
<form action="<@spring.url '/index'/>" method="post"  commandName="division">
				 <td colspan="2">
						<input type="submit" value="<@spring.message code="label.cancel"/>" />
				 </td>

