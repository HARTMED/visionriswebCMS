SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[installs]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[installs](
	[install_id] [int] IDENTITY(1,1) NOT NULL,
	[install_date] [datetime] NOT NULL,
	[client_name] [varchar](200) NOT NULL,
	[server_ram] [float] NULL,
	[server_hd] [float] NULL,
	[bin_tech_fullname] [varchar](200) NULL,
	[local_tech_fullname] [varchar](200) NULL,
	[local_tech_contact] [varchar](200) NULL,
	[main_radiolog_fullname] [varchar](200) NULL,
	[main_radiolog_contact] [varchar](200) NULL,
	[install_wanted_funcs] [varchar](200) NULL,
	[install_city] [varchar](max) NULL,
	[install_country] [varchar](200) NULL,
	[install_active_version] [varchar](200) NULL,
	[install_first_version] [varchar](200) NULL,
	[active_problems] [varchar](max) NULL,
	[recom_solutions] [varchar](max) NULL,
	[oper_status] [varchar](200) NULL,
	[server_bandwidth] [float] NULL,
	[install_url] [varchar](1000) NULL,
	[com_taken] [numeric](1, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[install_id] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
