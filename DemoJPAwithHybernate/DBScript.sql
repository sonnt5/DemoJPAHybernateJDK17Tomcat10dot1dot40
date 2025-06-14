USE [DemoHybernate]
GO
/****** Object:  Table [dbo].[Departments]    Script Date: 6/9/2025 9:50:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Departments](
	[did] [int] NOT NULL,
	[dname] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[did] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employee_Skill]    Script Date: 6/9/2025 9:50:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee_Skill](
	[eid] [int] NOT NULL,
	[skid] [int] NOT NULL,
	[startDate] [datetime2](6) NULL,
	[endDate] [datetime2](6) NULL,
 CONSTRAINT [PK_Employee_Skill] PRIMARY KEY CLUSTERED 
(
	[eid] ASC,
	[skid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employees]    Script Date: 6/9/2025 9:50:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employees](
	[eid] [int] IDENTITY(1,1) NOT NULL,
	[ename] [varchar](255) NULL,
	[gender] [bit] NOT NULL,
	[address] [varchar](255) NULL,
	[did] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[eid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Skills]    Script Date: 6/9/2025 9:50:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Skills](
	[skid] [int] NOT NULL,
	[skname] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[skid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Departments] ([did], [dname]) VALUES (1, N'Information Technology')
INSERT [dbo].[Departments] ([did], [dname]) VALUES (2, N'Accounting')
INSERT [dbo].[Departments] ([did], [dname]) VALUES (3, N'Human Resource Department')
INSERT [dbo].[Departments] ([did], [dname]) VALUES (4, N'Sales & Marketing')
GO
SET IDENTITY_INSERT [dbo].[Employees] ON 

INSERT [dbo].[Employees] ([eid], [ename], [gender], [address], [did]) VALUES (1, N'mr A', 0, N'ABCD', 1)
INSERT [dbo].[Employees] ([eid], [ename], [gender], [address], [did]) VALUES (2, N'2222', 1, N'2222', 1)
INSERT [dbo].[Employees] ([eid], [ename], [gender], [address], [did]) VALUES (3, N'3333', 0, N'3333', 2)
SET IDENTITY_INSERT [dbo].[Employees] OFF
GO
INSERT [dbo].[Skills] ([skid], [skname]) VALUES (1, N'Project Management')
INSERT [dbo].[Skills] ([skid], [skname]) VALUES (2, N'Tunnel Engineering')
INSERT [dbo].[Skills] ([skid], [skname]) VALUES (3, N'Trainer')
GO
ALTER TABLE [dbo].[Employee_Skill]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Skill_Employees] FOREIGN KEY([eid])
REFERENCES [dbo].[Employees] ([eid])
GO
ALTER TABLE [dbo].[Employee_Skill] CHECK CONSTRAINT [FK_Employee_Skill_Employees]
GO
ALTER TABLE [dbo].[Employee_Skill]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Skill_Skills] FOREIGN KEY([skid])
REFERENCES [dbo].[Skills] ([skid])
GO
ALTER TABLE [dbo].[Employee_Skill] CHECK CONSTRAINT [FK_Employee_Skill_Skills]
GO
ALTER TABLE [dbo].[Employees]  WITH CHECK ADD  CONSTRAINT [FK_Employees_Departments] FOREIGN KEY([did])
REFERENCES [dbo].[Departments] ([did])
GO
ALTER TABLE [dbo].[Employees] CHECK CONSTRAINT [FK_Employees_Departments]
GO
