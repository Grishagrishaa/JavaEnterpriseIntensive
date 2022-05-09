<%--
  Created by IntelliJ IDEA.
  User: GrigoryDmitrievich
  Date: 7.05.22
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        p{
            text-align: center;
        }
        form{
            text-align: center;
        }
    </style>

</head>
<body>
<p><img src="logo.png" alt="plane1"></p>
<p><img src="plane.png" alt="plane2"></p>

<p align="center">
<form  action="http://localhost:8080/JavaEnterpriseIntensive-1.0-SNAPSHOT/flightsWithFilter"  method="POST">
    <label for="start">Start date:</label>
    <input type="date" id="start" name="startDate">

    <label for="departureAirPort">Departure AirPort:</label>
    <select id="departureAirPort" name="departureAirPort">
        <option value="AAQ">AAQ</option>
        <option value="ABA">ABA</option>
        <option value="AER">AER</option>
        <option value="ARH">ARH</option>
        <option value="ASF">ASF</option>
        <option value="BAX">BAX</option>
        <option value="BQS">BQS</option>
        <option value="BTK">BTK</option>
        <option value="BZK">BZK</option>
        <option value="CEE">CEE</option>
        <option value="CEK">CEK</option>
        <option value="CNN">CNN</option>
        <option value="CSY">CSY</option>
        <option value="DME">DME</option>
        <option value="DYR">DYR</option>
        <option value="EGO">EGO</option>
        <option value="ESL">ESL</option>
        <option value="EYK">EYK</option>
        <option value="GDX">GDX</option>
        <option value="GDZ">GDZ</option>
        <option value="GOJ">GOJ</option>
        <option value="GRV">GRV</option>
        <option value="HMA">HMA</option>
        <option value="HTA">HTA</option>
        <option value="IAR">IAR</option>
        <option value="IJK">IJK</option>
        <option value="IKT">IKT</option>
        <option value="IWA">IWA</option>
        <option value="JOK">JOK</option>
        <option value="KEJ">KEJ</option>
        <option value="KGD">KGD</option>
        <option value="KGP">KGP</option>
        <option value="KHV">KHV</option>
        <option value="KJA">KJA</option>
        <option value="KLF">KLF</option>
        <option value="KRO">KRO</option>
        <option value="KRR">KRR</option>
        <option value="KUF">KUF</option>
        <option value="KVX">KVX</option>
        <option value="KXK">KXK</option>
        <option value="KYZ">KYZ</option>
        <option value="KZN">KZN</option>
        <option value="LED">LED</option>
        <option value="LPK">LPK</option>
        <option value="MCX">MCX</option>
        <option value="MJZ">MJZ</option>
        <option value="MMK">MMK</option>
        <option value="MQF">MQF</option>
        <option value="MRV">MRV</option>
        <option value="NAL">NAL</option>
        <option value="NBC">NBC</option>
        <option value="NFG">NFG</option>
        <option value="NJC">NJC</option>
        <option value="NNM">NNM</option>
        <option value="NOJ">NOJ</option>
        <option value="NOZ">NOZ</option>
        <option value="NSK">NSK</option>
        <option value="NUX">NUX</option>
        <option value="NYA">NYA</option>
        <option value="NYM">NYM</option>
        <option value="OGZ">OGZ</option>
        <option value="OMS">OMS</option>
        <option value="OSW">OSW</option>
        <option value="OVB">OVB</option>
        <option value="OVS">OVS</option>
        <option value="PEE">PEE</option>
        <option value="PES">PES</option>
        <option value="PEZ">PEZ</option>
        <option value="PKC">PKC</option>
        <option value="PKV">PKV</option>
        <option value="PYJ">PYJ</option>
        <option value="REN">REN</option>
        <option value="RGK">RGK</option>
        <option value="ROV">ROV</option>
        <option value="RTW">RTW</option>
        <option value="SCW">SCW</option>
        <option value="SGC">SGC</option>
        <option value="SKX">SKX</option>
        <option value="SLY">SLY</option>
        <option value="STW">STW</option>
        <option value="SVO">SVO</option>
        <option value="SVX">SVX</option>
        <option value="SWT">SWT</option>
        <option value="TBW">TBW</option>
        <option value="TJM">TJM</option>
        <option value="TOF">TOF</option>
        <option value="UCT">UCT</option>
        <option value="UFA">UFA</option>
        <option value="UIK">UIK</option>
        <option value="UKX">UKX</option>
        <option value="ULV">ULV</option>
        <option value="ULY">ULY</option>
        <option value="URJ">URJ</option>
        <option value="URS">URS</option>
        <option value="USK">USK</option>
        <option value="UUA">UUA</option>
        <option value="UUD">UUD</option>
        <option value="UUS">UUS</option>
        <option value="VKO">VKO</option>
        <option value="VKT">VKT</option>
        <option value="VOG">VOG</option>
        <option value="VOZ">VOZ</option>
        <option value="VVO">VVO</option>
        <option value="YKS">YKS</option>
    </select>

    <label for="arrival">Arrival date:</label>
    <input type="date" id="arrival" name="arrivalDate">

    <label for="arrivalAirPort">Arrival AirPort:</label>
    <select id="arrivalAirPort" name="arrivalAirPort">
        <option value="AAQ">AAQ</option>
        <option value="ABA">ABA</option>
        <option value="AER">AER</option>
        <option value="ARH">ARH</option>
        <option value="ASF">ASF</option>
        <option value="BAX">BAX</option>
        <option value="BQS">BQS</option>
        <option value="BTK">BTK</option>
        <option value="BZK">BZK</option>
        <option value="CEE">CEE</option>
        <option value="CEK">CEK</option>
        <option value="CNN">CNN</option>
        <option value="CSY">CSY</option>
        <option value="DME">DME</option>
        <option value="DYR">DYR</option>
        <option value="EGO">EGO</option>
        <option value="ESL">ESL</option>
        <option value="EYK">EYK</option>
        <option value="GDX">GDX</option>
        <option value="GDZ">GDZ</option>
        <option value="GOJ">GOJ</option>
        <option value="GRV">GRV</option>
        <option value="HMA">HMA</option>
        <option value="HTA">HTA</option>
        <option value="IAR">IAR</option>
        <option value="IJK">IJK</option>
        <option value="IKT">IKT</option>
        <option value="IWA">IWA</option>
        <option value="JOK">JOK</option>
        <option value="KEJ">KEJ</option>
        <option value="KGD">KGD</option>
        <option value="KGP">KGP</option>
        <option value="KHV">KHV</option>
        <option value="KJA">KJA</option>
        <option value="KLF">KLF</option>
        <option value="KRO">KRO</option>
        <option value="KRR">KRR</option>
        <option value="KUF">KUF</option>
        <option value="KVX">KVX</option>
        <option value="KXK">KXK</option>
        <option value="KYZ">KYZ</option>
        <option value="KZN">KZN</option>
        <option value="LED">LED</option>
        <option value="LPK">LPK</option>
        <option value="MCX">MCX</option>
        <option value="MJZ">MJZ</option>
        <option value="MMK">MMK</option>
        <option value="MQF">MQF</option>
        <option value="MRV">MRV</option>
        <option value="NAL">NAL</option>
        <option value="NBC">NBC</option>
        <option value="NFG">NFG</option>
        <option value="NJC">NJC</option>
        <option value="NNM">NNM</option>
        <option value="NOJ">NOJ</option>
        <option value="NOZ">NOZ</option>
        <option value="NSK">NSK</option>
        <option value="NUX">NUX</option>
        <option value="NYA">NYA</option>
        <option value="NYM">NYM</option>
        <option value="OGZ">OGZ</option>
        <option value="OMS">OMS</option>
        <option value="OSW">OSW</option>
        <option value="OVB">OVB</option>
        <option value="OVS">OVS</option>
        <option value="PEE">PEE</option>
        <option value="PES">PES</option>
        <option value="PEZ">PEZ</option>
        <option value="PKC">PKC</option>
        <option value="PKV">PKV</option>
        <option value="PYJ">PYJ</option>
        <option value="REN">REN</option>
        <option value="RGK">RGK</option>
        <option value="ROV">ROV</option>
        <option value="RTW">RTW</option>
        <option value="SCW">SCW</option>
        <option value="SGC">SGC</option>
        <option value="SKX">SKX</option>
        <option value="SLY">SLY</option>
        <option value="STW">STW</option>
        <option value="SVO">SVO</option>
        <option value="SVX">SVX</option>
        <option value="SWT">SWT</option>
        <option value="TBW">TBW</option>
        <option value="TJM">TJM</option>
        <option value="TOF">TOF</option>
        <option value="UCT">UCT</option>
        <option value="UFA">UFA</option>
        <option value="UIK">UIK</option>
        <option value="UKX">UKX</option>
        <option value="ULV">ULV</option>
        <option value="ULY">ULY</option>
        <option value="URJ">URJ</option>
        <option value="URS">URS</option>
        <option value="USK">USK</option>
        <option value="UUA">UUA</option>
        <option value="UUD">UUD</option>
        <option value="UUS">UUS</option>
        <option value="VKO">VKO</option>
        <option value="VKT">VKT</option>
        <option value="VOG">VOG</option>
        <option value="VOZ">VOZ</option>
        <option value="VVO">VVO</option>
        <option value="YKS">YKS</option>
    </select>
    <input type="submit" value="Find">
</form>
</p>


</body>
</html>
