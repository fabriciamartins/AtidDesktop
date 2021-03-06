<?xml version="1.0" encoding="UTF-8"?>
<!--
Copyright (C) 2008-2010 Martin Riesz <riesz.martin at gmail.com>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
-->
<xsl:transform version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="xml" omit-xml-declaration="no" indent="yes"/>

    <xsl:template match="/document">
        <document>
            <xsl:call-template name="compositeActivity"/>
        </document>
    </xsl:template>

    <xsl:template name="compositeActivity">
        <id><xsl:value-of select="id"/></id>
        <x><xsl:value-of select="x"/></x>
        <y><xsl:value-of select="y"/></y>
        <label><xsl:value-of select="label"/></label>
        <startDate><xsl:value-of select="startDate"/></startDate>
        <endDate><xsl:value-of select="endDate"/></endDate>
        <xsl:for-each select="simpleActivity">
            <simpleActivity>
                <id><xsl:value-of select="id"/></id>
                <x><xsl:value-of select="x"/></x>
                <y><xsl:value-of select="y"/></y>
                <label><xsl:value-of select="label"/></label>
                <startDate><xsl:value-of select="startDate"/></startDate>
                <endDate><xsl:value-of select="endDate"/></endDate>
                <tokens><xsl:value-of select="tokens"/></tokens>
                <isStatic><xsl:value-of select="isStatic"/></isStatic>
            </simpleActivity>
        </xsl:for-each>
        <xsl:for-each select="transition">
            <transition>
                <id><xsl:value-of select="id"/></id>
                <x><xsl:value-of select="x"/></x>
                <y><xsl:value-of select="y"/></y>
                <label><xsl:value-of select="label"/></label>
            </transition>
        </xsl:for-each>
        <xsl:for-each select="event">
            <event>
                <id><xsl:value-of select="id"/></id>
                <x><xsl:value-of select="x"/></x>
                <y><xsl:value-of select="y"/></y>
                <label><xsl:value-of select="label"/></label>
            </event>
        </xsl:for-each>
        <xsl:for-each select="repository">
            <repository>
                <id><xsl:value-of select="id"/></id>
                <x><xsl:value-of select="x"/></x>
                <y><xsl:value-of select="y"/></y>
                <label><xsl:value-of select="label"/></label>
            </repository>
        </xsl:for-each>
        <xsl:for-each select="arc">
            <arc>
                <type><xsl:value-of select="type"/></type>
                <sourceId><xsl:value-of select="sourceId"/></sourceId>
                <destinationId><xsl:value-of select="destinationId"/></destinationId>
                <xsl:for-each select="breakPoint">
                    <breakPoint>
                        <x><xsl:value-of select="x"/></x>
                        <y><xsl:value-of select="y"/></y>
                    </breakPoint>
                </xsl:for-each>
            </arc>
        </xsl:for-each>
        <xsl:for-each select="compositeActivity">
            <compositeActivity>
                <xsl:call-template name="compositeActivity"/>
            </compositeActivity>
        </xsl:for-each>
        <xsl:for-each select="rootCompositeActivity">
            <compositeActivity>
                <startDate><xsl:value-of select="startDate"/></startDate>
                <endDate><xsl:value-of select="endDate"/></endDate>
                <xsl:call-template name="compositeActivity"/>
            </compositeActivity>
        </xsl:for-each>
        <xsl:for-each select="referenceSimpleActivity">
            <referenceSimpleActivity>
                <id><xsl:value-of select="id"/></id>
                <x><xsl:value-of select="x"/></x>
                <y><xsl:value-of select="y"/></y>
                <connectedSimpleActivityId><xsl:value-of select="simpleActivityId"/></connectedSimpleActivityId>
            </referenceSimpleActivity>
        </xsl:for-each>
        <xsl:for-each select="referenceArc">
            <referenceArc>
                <simpleActivityId><xsl:value-of select="simpleActivityId"/></simpleActivityId>
                <compositeActivityId><xsl:value-of select="compositeActivityId"/></compositeActivityId>
                <xsl:for-each select="breakPoint">
                    <breakPoint>
                        <x><xsl:value-of select="x"/></x>
                        <y><xsl:value-of select="y"/></y>
                    </breakPoint>
                </xsl:for-each>
            </referenceArc>
        </xsl:for-each>
    </xsl:template>

</xsl:transform>