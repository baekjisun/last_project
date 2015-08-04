<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="guestlist">
		<xsl:for-each select="guest">
			<ul>
				<li><b>작성자 : </b><xsl:value-of select="writer"/></li>
				<li><b>남긴말 : </b><xsl:value-of select="genre"/></li>
			</ul>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>
