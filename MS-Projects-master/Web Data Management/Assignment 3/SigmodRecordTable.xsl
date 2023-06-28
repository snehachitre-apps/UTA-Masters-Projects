<!--Student Name  Sneha Chitre-->
<!-- Student ID    1001244953 -->

<xsl:stylesheet version = '1.0' 
     xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>

<xsl:template match="/"> 
	 <h1>Articles Sorted by Volumes</h1>
	 <br/>
	 <xsl:for-each select="//issue"> 
	 <ol style="list-style-type:disc"><li>
			<h2>Volume Details</h2>
			<table border="1">
			<tr><th>Volume</th><td><xsl:value-of select="volume"/> </td></tr>
			<tr><th>Number</th><td><xsl:value-of select="number"/> </td></tr>
			</table>
			
			<p><u>List of articles</u></p>
		<xsl:for-each select="articles/*">
					<ol style="list-style-type:square"><li>
					<table border="1">
					
						<tr><th>Title</th><th>Start Page</th><th>End Page</th></tr>
						
						<tr><td><xsl:value-of select="title"/></td><td><xsl:value-of select="initPage"/></td><td><xsl:value-of select="endPage"/></td></tr>
						
						<br/>
						
						 <table border="0">	
						 <p><u>Author(s)</u></p>
							<xsl:for-each select="authors/*">
							
											
							 <tr>
							 <td>
								<xsl:apply-templates>
									<xsl:value-of select="author" />
								</xsl:apply-templates>
								</td>
							</tr>
							
							
							</xsl:for-each>
						
						</table>
						
				</table>
		</li>		
</ol>				
		</xsl:for-each>
		<br/>
</li></ol>				
     </xsl:for-each>

	
</xsl:template>


</xsl:stylesheet>