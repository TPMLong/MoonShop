USE [master]
GO
/****** Object:  Database [MoonShop]    Script Date: 10/18/2020 4:49:41 PM ******/
CREATE DATABASE [MoonShop]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MoonShop', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\MoonShop.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'MoonShop_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\MoonShop_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [MoonShop] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MoonShop].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MoonShop] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [MoonShop] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [MoonShop] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [MoonShop] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [MoonShop] SET ARITHABORT OFF 
GO
ALTER DATABASE [MoonShop] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [MoonShop] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [MoonShop] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [MoonShop] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [MoonShop] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [MoonShop] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [MoonShop] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [MoonShop] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [MoonShop] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [MoonShop] SET  DISABLE_BROKER 
GO
ALTER DATABASE [MoonShop] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [MoonShop] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [MoonShop] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [MoonShop] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [MoonShop] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [MoonShop] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [MoonShop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [MoonShop] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [MoonShop] SET  MULTI_USER 
GO
ALTER DATABASE [MoonShop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MoonShop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MoonShop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MoonShop] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [MoonShop] SET DELAYED_DURABILITY = DISABLED 
GO
USE [MoonShop]
GO
/****** Object:  Table [dbo].[tblCategory]    Script Date: 10/18/2020 4:49:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblCategory](
	[categoryID] [int] NOT NULL,
	[name] [varchar](50) NULL,
 CONSTRAINT [PK_tblCategory] PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblOrder]    Script Date: 10/18/2020 4:49:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblOrder](
	[orderID] [int] IDENTITY(1,1) NOT NULL,
	[userID] [varchar](50) NULL,
	[total] [float] NULL,
	[date] [date] NULL,
	[address] [varchar](50) NULL,
 CONSTRAINT [PK_tblOrder] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblOrderdetail]    Script Date: 10/18/2020 4:49:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblOrderdetail](
	[detailID] [int] IDENTITY(1,1) NOT NULL,
	[orderID] [int] NULL,
	[productID] [int] NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
 CONSTRAINT [PK_tblOrderdetail] PRIMARY KEY CLUSTERED 
(
	[detailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblProducts]    Script Date: 10/18/2020 4:49:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblProducts](
	[productID] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
	[price] [float] NULL,
	[quantity] [int] NULL,
	[categoryID] [int] NULL,
	[image] [varchar](50) NULL,
	[createDate] [date] NULL,
	[expirationDate] [date] NULL,
	[status] [varchar](50) NULL,
 CONSTRAINT [PK_tblProducts] PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblRoles]    Script Date: 10/18/2020 4:49:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblRoles](
	[roleID] [int] NOT NULL,
	[name] [varchar](50) NULL,
 CONSTRAINT [PK_tblRoles] PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblUsers]    Script Date: 10/18/2020 4:49:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblUsers](
	[userID] [varchar](50) NOT NULL,
	[name] [varchar](50) NULL,
	[phone] [int] NULL,
	[address] [varchar](50) NULL,
	[roleID] [int] NULL,
	[password] [varchar](50) NULL,
 CONSTRAINT [PK_tblUsers] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tblCategory] ([categoryID], [name]) VALUES (1, N'banh nhan thit')
INSERT [dbo].[tblCategory] ([categoryID], [name]) VALUES (2, N'banh nhan xiu mai')
INSERT [dbo].[tblCategory] ([categoryID], [name]) VALUES (3, N'banh nhan thit ')
SET IDENTITY_INSERT [dbo].[tblOrder] ON 

INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (1, N'lon', 2, NULL, NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (2, N'lon', 2, NULL, NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (3, N'lon', 1, NULL, NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (5, N'longg', 2, CAST(N'2020-09-18' AS Date), N'longa')
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (6, N'lonzzz', 2, CAST(N'2020-09-18' AS Date), N'lonly')
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (7, N'linh', 2, CAST(N'2020-09-18' AS Date), N'linh')
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (8, N'linha', 22, CAST(N'2020-09-18' AS Date), N'linha')
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (9, NULL, 2, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (10, NULL, 24, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (11, NULL, 20, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (12, NULL, 19, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (13, NULL, 19, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (14, NULL, 19, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (15, NULL, 38, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (16, NULL, 19, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (17, NULL, 19, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (18, NULL, 21, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (19, N'lon', 23, NULL, N'141 cong hoa')
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (20, NULL, 19, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (21, NULL, 19, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (22, N'lon', 19, CAST(N'2020-09-18' AS Date), N'lon')
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (23, NULL, 19, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (24, N'lon', 23, CAST(N'2020-09-18' AS Date), N'141 Cong Hoa')
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (25, NULL, 23, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (26, N'lon', 1, CAST(N'2020-09-18' AS Date), N'141 Cong Hoa')
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (27, NULL, 1, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (28, N'lon', 19, CAST(N'2020-09-18' AS Date), N'141 Cong Hoa')
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (29, NULL, 19, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (30, N'lon', 19, CAST(N'2020-09-18' AS Date), N'141 Cong Hoa')
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (31, NULL, 19, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (32, N'lon', 19, CAST(N'2020-09-18' AS Date), N'141 Cong Hoa')
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (33, NULL, 19, CAST(N'2020-09-18' AS Date), NULL)
INSERT [dbo].[tblOrder] ([orderID], [userID], [total], [date], [address]) VALUES (34, N'lon', 19, CAST(N'2020-09-18' AS Date), N'141 Cong Hoa')
SET IDENTITY_INSERT [dbo].[tblOrder] OFF
SET IDENTITY_INSERT [dbo].[tblOrderdetail] ON 

INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (1, 1, 1, 1, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (2, 1, 2, 2, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (3, 1, 1, 1, 5)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (4, 7, 7, 2, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (5, 8, 1, 1, 10)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (6, 8, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (7, 8, 7, 2, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (8, 9, 7, 2, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (9, 10, 1, 1, 10)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (10, 10, 2, 2, 10)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (11, 10, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (12, 10, 7, 2, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (13, 11, 1, 1, 10)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (14, 11, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (15, 12, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (16, 13, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (17, 14, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (18, 15, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (19, 16, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (20, 17, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (21, 18, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (22, 18, 7, 2, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (23, 20, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (24, 21, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (25, 22, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (26, 23, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (27, 24, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (28, 24, 7, 2, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (29, 25, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (30, 25, 7, 2, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (31, 26, 1, 1, 10)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (32, 27, 1, 1, 10)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (33, 28, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (34, 29, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (35, 30, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (36, 31, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (37, 32, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (38, 33, 6, 19, 2)
INSERT [dbo].[tblOrderdetail] ([detailID], [orderID], [productID], [price], [quantity]) VALUES (39, 34, 6, 19, 2)
SET IDENTITY_INSERT [dbo].[tblOrderdetail] OFF
SET IDENTITY_INSERT [dbo].[tblProducts] ON 

INSERT [dbo].[tblProducts] ([productID], [name], [price], [quantity], [categoryID], [image], [createDate], [expirationDate], [status]) VALUES (1, N'banh bao', 1, 10, 2, N'bao.jpg', CAST(N'2000-09-02' AS Date), CAST(N'2001-09-02' AS Date), N'active')
INSERT [dbo].[tblProducts] ([productID], [name], [price], [quantity], [categoryID], [image], [createDate], [expirationDate], [status]) VALUES (2, N'banh pia', 2, 10, 1, N'pia.jpg', CAST(N'1999-09-02' AS Date), CAST(N'2000-09-02' AS Date), N'active')
INSERT [dbo].[tblProducts] ([productID], [name], [price], [quantity], [categoryID], [image], [createDate], [expirationDate], [status]) VALUES (3, N'banh bo', 3, 100, 1, N'bao.jpg', CAST(N'1000-08-02' AS Date), CAST(N'1999-09-02' AS Date), N'delete')
INSERT [dbo].[tblProducts] ([productID], [name], [price], [quantity], [categoryID], [image], [createDate], [expirationDate], [status]) VALUES (4, N'banh gio', 1, 0, 1, N'bao.jpg', CAST(N'1000-08-02' AS Date), CAST(N'1900-09-02' AS Date), N'active')
INSERT [dbo].[tblProducts] ([productID], [name], [price], [quantity], [categoryID], [image], [createDate], [expirationDate], [status]) VALUES (6, N'banh cam', 19, 2, 1, N'bao.jpg', CAST(N'3000-02-01' AS Date), CAST(N'3010-02-01' AS Date), N'active')
INSERT [dbo].[tblProducts] ([productID], [name], [price], [quantity], [categoryID], [image], [createDate], [expirationDate], [status]) VALUES (7, N'banh cam', 2, 2, 2, N'cam.jpg', CAST(N'4950-01-01' AS Date), CAST(N'4980-01-01' AS Date), N'active')
SET IDENTITY_INSERT [dbo].[tblProducts] OFF
INSERT [dbo].[tblRoles] ([roleID], [name]) VALUES (1, N'Admin')
INSERT [dbo].[tblRoles] ([roleID], [name]) VALUES (2, N'Member')
INSERT [dbo].[tblRoles] ([roleID], [name]) VALUES (3, N'Guest')
INSERT [dbo].[tblUsers] ([userID], [name], [phone], [address], [roleID], [password]) VALUES (N'lon', N'lon', 794408658, N'141 Cong Hoa', 2, N'lon')
INSERT [dbo].[tblUsers] ([userID], [name], [phone], [address], [roleID], [password]) VALUES (N'long', N'long', 794408658, N'141 Cong Hoa', 1, N'long')
ALTER TABLE [dbo].[tblOrderdetail]  WITH CHECK ADD  CONSTRAINT [FK_tblOrderdetail_tblOrder] FOREIGN KEY([orderID])
REFERENCES [dbo].[tblOrder] ([orderID])
GO
ALTER TABLE [dbo].[tblOrderdetail] CHECK CONSTRAINT [FK_tblOrderdetail_tblOrder]
GO
ALTER TABLE [dbo].[tblOrderdetail]  WITH CHECK ADD  CONSTRAINT [FK_tblOrderdetail_tblProducts] FOREIGN KEY([productID])
REFERENCES [dbo].[tblProducts] ([productID])
GO
ALTER TABLE [dbo].[tblOrderdetail] CHECK CONSTRAINT [FK_tblOrderdetail_tblProducts]
GO
ALTER TABLE [dbo].[tblProducts]  WITH CHECK ADD  CONSTRAINT [FK_tblProducts_tblCategory] FOREIGN KEY([categoryID])
REFERENCES [dbo].[tblCategory] ([categoryID])
GO
ALTER TABLE [dbo].[tblProducts] CHECK CONSTRAINT [FK_tblProducts_tblCategory]
GO
ALTER TABLE [dbo].[tblUsers]  WITH CHECK ADD  CONSTRAINT [FK_tblUsers_tblRoles] FOREIGN KEY([roleID])
REFERENCES [dbo].[tblRoles] ([roleID])
GO
ALTER TABLE [dbo].[tblUsers] CHECK CONSTRAINT [FK_tblUsers_tblRoles]
GO
USE [master]
GO
ALTER DATABASE [MoonShop] SET  READ_WRITE 
GO
