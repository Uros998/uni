<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="Zadatak4._Default" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
    <asp:Label ID="Label1" CssClass =" label label-info " runat="server" Text="Unesite rec"></asp:Label>

    <asp:TextBox CssClass="active input-group-text" ID="TextBox1" runat="server" Text=""></asp:TextBox>

    <asp:Button ID="Button1" CssClass ="btn btn-primary" runat="server" Text="Button" OnClick="Button1_Click" />

     <asp:Label ID="Label2" runat="server" Text=""></asp:Label>

</asp:Content>
