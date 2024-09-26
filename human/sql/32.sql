This is not SQL code, it's a fragment of a .NET configuration file (web.config). 

However, if you're looking to create the corresponding SQL tables for the ASP.NET Membership provider, here is the SQL script:


CREATE TABLE [dbo].[aspnet_Applications](
    [ApplicationId] [uniqueidentifier] NOT NULL DEFAULT (newid()),
    [ApplicationName] [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [LoweredApplicationName] [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [Description] [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
 CONSTRAINT [PK__aspnet_Applicatio__17477DFC] PRIMARY KEY CLUSTERED 
(
    [ApplicationId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [dbo].[aspnet_Membership](
    [UserId] [uniqueidentifier] NOT NULL,
    [PasswordHash] [nvarchar](128) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [PasswordSalt] [nvarchar](16) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [Email] [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [LoweredEmail] [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [PasswordQuestion] [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [PasswordAnswer] [nvarchar](128) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [IsApproved] [bit] NOT NULL,
    [IsLockedOut] [bit] NOT NULL,
    [CreateDate] [datetime] NOT NULL,
    [LastLoginDate] [datetime] NOT NULL,
    [LastPasswordChangedDate] [datetime] NOT NULL,
    [LastLockoutDate] [datetime] NOT NULL,
    [FailedPasswordAttemptCount] [int] NOT NULL,
    [FailedPasswordAttemptWindowStart] [datetime] NOT NULL,
    [FailedPasswordAnswerAttemptCount] [int] NOT NULL,
    [FailedPasswordAnswerAttemptWindowStart] [datetime] NOT NULL,
    [Comment] [ntext] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
 CONSTRAINT [PK__aspnet_Membershi__0CF04B18] PRIMARY KEY CLUSTERED 
(
    [UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

CREATE TABLE [dbo].[aspnet_Roles](
    [RoleId] [uniqueidentifier] NOT NULL DEFAULT (newid()),
    [ApplicationId] [uniqueidentifier] NOT NULL,
    [RoleName] [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [LoweredRoleName] [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [Description] [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
 CONSTRAINT [PK__aspnet_Roles__31EC6DC9] PRIMARY KEY CLUSTERED 
(
    [RoleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [dbo].[aspnet_Users](
    [UserId] [uniqueidentifier] NOT NULL DEFAULT (newid()),
    [ApplicationId] [uniqueidentifier] NOT NULL,
    [UserName] [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [LoweredUserName] [nvarchar](256) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [MobileAlias] [nvarchar](16) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [IsAnonymous] [bit] NOT NULL,
    [LastActivityDate] [datetime] NOT NULL,
 CONSTRAINT [PK__aspnet_Users__03317E3D] PRIMARY KEY CLUSTERED 
(
    [UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [dbo].[aspnet_UsersInRoles](
    [UserId] [uniqueidentifier] NOT NULL,
    [RoleId] [uniqueidentifier] NOT NULL,
 CONSTRAINT [PK__aspnet_UsersInRo__19C3A179] PRIMARY KEY CLUSTERED 
(
    [UserId] ASC,
    [RoleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


Please note that you need to adjust the script according to your database schema and needs.