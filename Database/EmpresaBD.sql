USE [master]
GO
/****** Object:  Database [empresa]    Script Date: 19/04/2022 13:40:16 ******/
CREATE DATABASE [empresa]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'empresa', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\empresa.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'empresa_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\empresa_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [empresa] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [empresa].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [empresa] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [empresa] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [empresa] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [empresa] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [empresa] SET ARITHABORT OFF 
GO
ALTER DATABASE [empresa] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [empresa] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [empresa] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [empresa] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [empresa] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [empresa] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [empresa] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [empresa] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [empresa] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [empresa] SET  DISABLE_BROKER 
GO
ALTER DATABASE [empresa] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [empresa] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [empresa] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [empresa] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [empresa] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [empresa] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [empresa] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [empresa] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [empresa] SET  MULTI_USER 
GO
ALTER DATABASE [empresa] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [empresa] SET DB_CHAINING OFF 
GO
ALTER DATABASE [empresa] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [empresa] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [empresa] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [empresa] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [empresa] SET QUERY_STORE = OFF
GO
USE [empresa]
GO
/****** Object:  User [santa]    Script Date: 19/04/2022 13:40:17 ******/
CREATE USER [santa] FOR LOGIN [santa] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [LAPTOP-CM9A98PI/ma_le]    Script Date: 19/04/2022 13:40:17 ******/
CREATE USER [LAPTOP-CM9A98PI/ma_le] FOR LOGIN [LAPTOP-CM9A98PI/ma_le] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[ventas]    Script Date: 19/04/2022 13:40:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ventas](
	[id_venta] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [varchar](60) NULL,
	[id_cliente] [int] NULL,
	[id_forma_pago] [int] NULL,
	[id_usuario] [int] NULL,
	[importe] [varchar](60) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_venta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[detalle_venta]    Script Date: 19/04/2022 13:40:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[detalle_venta](
	[id_venta] [int] NULL,
	[id_producto] [int] NULL,
	[importe] [decimal](18, 2) NULL,
	[cantidad] [decimal](18, 2) NULL,
	[importe_r] [decimal](18, 2) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[productos]    Script Date: 19/04/2022 13:40:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[productos](
	[id_producto] [int] IDENTITY(1,1) NOT NULL,
	[id_proveedor] [int] NULL,
	[descripcion] [varchar](60) NULL,
	[stock] [varchar](60) NULL,
	[importe] [varchar](60) NULL,
 CONSTRAINT [PK__producto__FF341C0D0D536F68] PRIMARY KEY CLUSTERED 
(
	[id_producto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[visordetalleventa]    Script Date: 19/04/2022 13:40:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[visordetalleventa] as
select id_venta as 'Numero de venta', descripcion as 'Producto', 
detalle_venta.importe as 'Importe', cantidad as 'Cantidad', importe_r as 'Total'
from detalle_venta
join productos on productos.id_producto = detalle_venta.id_producto
where id_venta = (select max(id_venta) from ventas)
GO
/****** Object:  Table [dbo].[usuarios]    Script Date: 19/04/2022 13:40:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[usuarios](
	[id_usuario] [int] IDENTITY(1,1) NOT NULL,
	[usuario] [varchar](60) NULL,
	[pass] [varchar](60) NULL,
	[permiso] [varchar](60) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_usuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[formas_pago]    Script Date: 19/04/2022 13:40:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[formas_pago](
	[id_forma_pago] [int] IDENTITY(1,1) NOT NULL,
	[descript_forma_pago] [varchar](60) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_forma_pago] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[clientes]    Script Date: 19/04/2022 13:40:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[clientes](
	[id_cliente] [int] IDENTITY(1,1) NOT NULL,
	[razon_social] [varchar](60) NULL,
	[telefono] [varchar](60) NULL,
	[cp] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_cliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[visorventa]    Script Date: 19/04/2022 13:40:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[visorventa] as 
select TOP 1 id_venta as 'Número de venta', fecha as 'Fecha', razon_social as 'Nombre de cliente',
descript_forma_pago as 'Forma de pago', usuario as 'Usuario', importe as 'Importe total' from ventas
join clientes on clientes.id_cliente = ventas.id_cliente
join formas_pago on formas_pago.id_forma_pago = ventas.id_forma_pago
join usuarios on usuarios.id_usuario = ventas.id_usuario
where id_venta = (select max(id_venta) from ventas)
GO
/****** Object:  View [dbo].[visordetalleventa1]    Script Date: 19/04/2022 13:40:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[visordetalleventa1] as
select id_venta, descripcion, 
detalle_venta.importe, cantidad, importe_r
from detalle_venta
join productos on productos.id_producto = detalle_venta.id_producto
where id_venta = (select max(id_venta) from ventas)
GO
/****** Object:  View [dbo].[visorventa1]    Script Date: 19/04/2022 13:40:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[visorventa1] as 
select TOP 1 id_venta, fecha, razon_social,
descript_forma_pago, usuario, importe from ventas
join clientes on clientes.id_cliente = ventas.id_cliente
join formas_pago on formas_pago.id_forma_pago = ventas.id_forma_pago
join usuarios on usuarios.id_usuario = ventas.id_usuario
where id_venta = (select max(id_venta) from ventas)
GO
/****** Object:  View [dbo].[visordetodo]    Script Date: 19/04/2022 13:40:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[visordetodo] as
select detalle_venta.id_venta, descripcion, cantidad, importe_r, fecha, razon_social,
descript_forma_pago, usuario, ventas.importe
from ventas
join usuarios on usuarios.id_usuario = ventas.id_usuario
join clientes on clientes.id_cliente = ventas.id_cliente
join formas_pago on formas_pago.id_forma_pago = ventas.id_forma_pago
join detalle_venta on detalle_venta.id_venta = ventas.id_venta
join productos on productos.id_producto = detalle_venta.id_producto
where ventas.id_venta = (select max(id_venta) from ventas)
GO
/****** Object:  Table [dbo].[localidades]    Script Date: 19/04/2022 13:40:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[localidades](
	[cp] [int] NOT NULL,
	[id_provincia] [int] NULL,
	[localidad] [varchar](60) NULL,
PRIMARY KEY CLUSTERED 
(
	[cp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[proveedores]    Script Date: 19/04/2022 13:40:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[proveedores](
	[id_proveedor] [int] IDENTITY(1,1) NOT NULL,
	[razon_social_proveedor] [varchar](60) NULL,
	[telefono_proveedor] [varchar](60) NULL,
	[cp] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_proveedor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[provincias]    Script Date: 19/04/2022 13:40:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[provincias](
	[id_provincia] [int] NOT NULL,
	[provincia] [varchar](60) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_provincia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[clientes]  WITH CHECK ADD FOREIGN KEY([cp])
REFERENCES [dbo].[localidades] ([cp])
GO
ALTER TABLE [dbo].[detalle_venta]  WITH CHECK ADD  CONSTRAINT [FK__detalle_v__id_pr__3C34F16F] FOREIGN KEY([id_producto])
REFERENCES [dbo].[productos] ([id_producto])
GO
ALTER TABLE [dbo].[detalle_venta] CHECK CONSTRAINT [FK__detalle_v__id_pr__3C34F16F]
GO
ALTER TABLE [dbo].[detalle_venta]  WITH CHECK ADD FOREIGN KEY([id_venta])
REFERENCES [dbo].[ventas] ([id_venta])
GO
ALTER TABLE [dbo].[localidades]  WITH CHECK ADD FOREIGN KEY([id_provincia])
REFERENCES [dbo].[provincias] ([id_provincia])
GO
ALTER TABLE [dbo].[productos]  WITH CHECK ADD  CONSTRAINT [FK__productos__id_pr__607251E5] FOREIGN KEY([id_proveedor])
REFERENCES [dbo].[proveedores] ([id_proveedor])
GO
ALTER TABLE [dbo].[productos] CHECK CONSTRAINT [FK__productos__id_pr__607251E5]
GO
ALTER TABLE [dbo].[proveedores]  WITH CHECK ADD FOREIGN KEY([cp])
REFERENCES [dbo].[localidades] ([cp])
GO
ALTER TABLE [dbo].[ventas]  WITH CHECK ADD FOREIGN KEY([id_cliente])
REFERENCES [dbo].[clientes] ([id_cliente])
GO
ALTER TABLE [dbo].[ventas]  WITH CHECK ADD FOREIGN KEY([id_forma_pago])
REFERENCES [dbo].[formas_pago] ([id_forma_pago])
GO
ALTER TABLE [dbo].[ventas]  WITH CHECK ADD FOREIGN KEY([id_usuario])
REFERENCES [dbo].[usuarios] ([id_usuario])
GO
USE [master]
GO
ALTER DATABASE [empresa] SET  READ_WRITE 
GO
