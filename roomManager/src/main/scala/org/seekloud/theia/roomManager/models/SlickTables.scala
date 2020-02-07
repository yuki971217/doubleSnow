package org.seekloud.theia.roomManager.models

// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object SlickTables extends {
  val profile = slick.jdbc.H2Profile
} with SlickTables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait SlickTables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = tAttendEvent.schema ++ tLoginEvent.schema ++ tRoom.schema ++ tUserInfo.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table tAttendEvent
   *  @param id Database column ID SqlType(BIGINT), PrimaryKey
   *  @param uid Database column UID SqlType(BIGINT)
   *  @param roomid Database column ROOMID SqlType(BIGINT)
   *  @param temporary Database column TEMPORARY SqlType(BOOLEAN), Default(false)
   *  @param inTime Database column IN_TIME SqlType(BIGINT), Default(0)
   *  @param outTime Database column OUT_TIME SqlType(BIGINT), Default(0) */
  case class rAttendEvent(id: Long, uid: Long, roomid: Long, temporary: Boolean = false, inTime: Long = 0L, outTime: Long = 0L)
  /** GetResult implicit for fetching rAttendEvent objects using plain SQL queries */
  implicit def GetResultrAttendEvent(implicit e0: GR[Long], e1: GR[Boolean]): GR[rAttendEvent] = GR{
    prs => import prs._
    rAttendEvent.tupled((<<[Long], <<[Long], <<[Long], <<[Boolean], <<[Long], <<[Long]))
  }
  /** Table description of table ATTEND_EVENT. Objects of this class serve as prototypes for rows in queries. */
  class tAttendEvent(_tableTag: Tag) extends profile.api.Table[rAttendEvent](_tableTag, Some("PUBLIC"), "ATTEND_EVENT") {
    def * = (id, uid, roomid, temporary, inTime, outTime) <> (rAttendEvent.tupled, rAttendEvent.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(uid), Rep.Some(roomid), Rep.Some(temporary), Rep.Some(inTime), Rep.Some(outTime))).shaped.<>({r=>import r._; _1.map(_=> rAttendEvent.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(BIGINT), PrimaryKey */
    val id: Rep[Long] = column[Long]("ID", O.PrimaryKey)
    /** Database column UID SqlType(BIGINT) */
    val uid: Rep[Long] = column[Long]("UID")
    /** Database column ROOMID SqlType(BIGINT) */
    val roomid: Rep[Long] = column[Long]("ROOMID")
    /** Database column TEMPORARY SqlType(BOOLEAN), Default(false) */
    val temporary: Rep[Boolean] = column[Boolean]("TEMPORARY", O.Default(false))
    /** Database column IN_TIME SqlType(BIGINT), Default(0) */
    val inTime: Rep[Long] = column[Long]("IN_TIME", O.Default(0L))
    /** Database column OUT_TIME SqlType(BIGINT), Default(0) */
    val outTime: Rep[Long] = column[Long]("OUT_TIME", O.Default(0L))
  }
  /** Collection-like TableQuery object for table tAttendEvent */
  lazy val tAttendEvent = new TableQuery(tag => new tAttendEvent(tag))

  /** Entity class storing rows of table tLoginEvent
   *  @param id Database column ID SqlType(BIGINT), PrimaryKey
   *  @param uid Database column UID SqlType(BIGINT)
   *  @param loginTime Database column LOGIN_TIME SqlType(BIGINT), Default(0) */
  case class rLoginEvent(id: Long, uid: Long, loginTime: Long = 0L)
  /** GetResult implicit for fetching rLoginEvent objects using plain SQL queries */
  implicit def GetResultrLoginEvent(implicit e0: GR[Long]): GR[rLoginEvent] = GR{
    prs => import prs._
    rLoginEvent.tupled((<<[Long], <<[Long], <<[Long]))
  }
  /** Table description of table LOGIN_EVENT. Objects of this class serve as prototypes for rows in queries. */
  class tLoginEvent(_tableTag: Tag) extends profile.api.Table[rLoginEvent](_tableTag, Some("PUBLIC"), "LOGIN_EVENT") {
    def * = (id, uid, loginTime) <> (rLoginEvent.tupled, rLoginEvent.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(uid), Rep.Some(loginTime))).shaped.<>({r=>import r._; _1.map(_=> rLoginEvent.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(BIGINT), PrimaryKey */
    val id: Rep[Long] = column[Long]("ID", O.PrimaryKey)
    /** Database column UID SqlType(BIGINT) */
    val uid: Rep[Long] = column[Long]("UID")
    /** Database column LOGIN_TIME SqlType(BIGINT), Default(0) */
    val loginTime: Rep[Long] = column[Long]("LOGIN_TIME", O.Default(0L))
  }
  /** Collection-like TableQuery object for table tLoginEvent */
  lazy val tLoginEvent = new TableQuery(tag => new tLoginEvent(tag))

  /** Entity class storing rows of table tRoom
   *  @param roomid Database column ROOMID SqlType(BIGINT), PrimaryKey
   *  @param roomName Database column ROOM_NAME SqlType(VARCHAR), Length(256,true), Default()
   *  @param roomDesc Database column ROOM_DESC SqlType(VARCHAR), Length(256,true), Default()
   *  @param coverImg Database column COVER_IMG SqlType(VARCHAR), Length(256,true), Default()
   *  @param startTime Database column START_TIME SqlType(BIGINT)
   *  @param endTime Database column END_TIME SqlType(BIGINT), Default(0)
   *  @param anchorid Database column ANCHORID SqlType(BIGINT) */
  case class rRoom(roomid: Long, roomName: String = "", roomDesc: String = "", coverImg: String = "", startTime: Long, endTime: Long = 0L, anchorid: Long)
  /** GetResult implicit for fetching rRoom objects using plain SQL queries */
  implicit def GetResultrRoom(implicit e0: GR[Long], e1: GR[String]): GR[rRoom] = GR{
    prs => import prs._
    rRoom.tupled((<<[Long], <<[String], <<[String], <<[String], <<[Long], <<[Long], <<[Long]))
  }
  /** Table description of table ROOM. Objects of this class serve as prototypes for rows in queries. */
  class tRoom(_tableTag: Tag) extends profile.api.Table[rRoom](_tableTag, Some("PUBLIC"), "ROOM") {
    def * = (roomid, roomName, roomDesc, coverImg, startTime, endTime, anchorid) <> (rRoom.tupled, rRoom.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(roomid), Rep.Some(roomName), Rep.Some(roomDesc), Rep.Some(coverImg), Rep.Some(startTime), Rep.Some(endTime), Rep.Some(anchorid))).shaped.<>({r=>import r._; _1.map(_=> rRoom.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ROOMID SqlType(BIGINT), PrimaryKey */
    val roomid: Rep[Long] = column[Long]("ROOMID", O.PrimaryKey)
    /** Database column ROOM_NAME SqlType(VARCHAR), Length(256,true), Default() */
    val roomName: Rep[String] = column[String]("ROOM_NAME", O.Length(256,varying=true), O.Default(""))
    /** Database column ROOM_DESC SqlType(VARCHAR), Length(256,true), Default() */
    val roomDesc: Rep[String] = column[String]("ROOM_DESC", O.Length(256,varying=true), O.Default(""))
    /** Database column COVER_IMG SqlType(VARCHAR), Length(256,true), Default() */
    val coverImg: Rep[String] = column[String]("COVER_IMG", O.Length(256,varying=true), O.Default(""))
    /** Database column START_TIME SqlType(BIGINT) */
    val startTime: Rep[Long] = column[Long]("START_TIME")
    /** Database column END_TIME SqlType(BIGINT), Default(0) */
    val endTime: Rep[Long] = column[Long]("END_TIME", O.Default(0L))
    /** Database column ANCHORID SqlType(BIGINT) */
    val anchorid: Rep[Long] = column[Long]("ANCHORID")
  }
  /** Collection-like TableQuery object for table tRoom */
  lazy val tRoom = new TableQuery(tag => new tRoom(tag))

  /** Entity class storing rows of table tUserInfo
   *  @param uid Database column UID SqlType(BIGINT), PrimaryKey
   *  @param userName Database column USER_NAME SqlType(VARCHAR), Length(100,true)
   *  @param password Database column PASSWORD SqlType(VARCHAR), Length(100,true)
   *  @param roomid Database column ROOMID SqlType(BIGINT), Default(0)
   *  @param token Database column TOKEN SqlType(VARCHAR), Length(63,true), Default()
   *  @param tokenCreateTime Database column TOKEN_CREATE_TIME SqlType(BIGINT)
   *  @param headImg Database column HEAD_IMG SqlType(VARCHAR), Length(256,true), Default()
   *  @param coverImg Database column COVER_IMG SqlType(VARCHAR), Length(256,true), Default()
   *  @param email Database column EMAIL SqlType(VARCHAR), Length(256,true), Default()
   *  @param createTime Database column CREATE_TIME SqlType(BIGINT)
   *  @param rtmpToken Database column RTMP_TOKEN SqlType(VARCHAR), Length(256,true), Default()
   *  @param `sealed` Database column SEALED SqlType(BOOLEAN), Default(false)
   *  @param sealedUtilTime Database column SEALED_UTIL_TIME SqlType(BIGINT), Default(0)
   *  @param allowAnchor Database column ALLOW_ANCHOR SqlType(BOOLEAN), Default(true) */
  case class rUserInfo(uid: Long, userName: String, password: String, roomid: Long = 0L, token: String = "", tokenCreateTime: Long, headImg: String = "", coverImg: String = "", email: String = "", createTime: Long, rtmpToken: String = "", `sealed`: Boolean = false, sealedUtilTime: Long = 0L, allowAnchor: Boolean = true)
  /** GetResult implicit for fetching rUserInfo objects using plain SQL queries */
  implicit def GetResultrUserInfo(implicit e0: GR[Long], e1: GR[String], e2: GR[Boolean]): GR[rUserInfo] = GR{
    prs => import prs._
    rUserInfo.tupled((<<[Long], <<[String], <<[String], <<[Long], <<[String], <<[Long], <<[String], <<[String], <<[String], <<[Long], <<[String], <<[Boolean], <<[Long], <<[Boolean]))
  }
  /** Table description of table USER_INFO. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: sealed */
  class tUserInfo(_tableTag: Tag) extends profile.api.Table[rUserInfo](_tableTag, Some("PUBLIC"), "USER_INFO") {
    def * = (uid, userName, password, roomid, token, tokenCreateTime, headImg, coverImg, email, createTime, rtmpToken, `sealed`, sealedUtilTime, allowAnchor) <> (rUserInfo.tupled, rUserInfo.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(uid), Rep.Some(userName), Rep.Some(password), Rep.Some(roomid), Rep.Some(token), Rep.Some(tokenCreateTime), Rep.Some(headImg), Rep.Some(coverImg), Rep.Some(email), Rep.Some(createTime), Rep.Some(rtmpToken), Rep.Some(`sealed`), Rep.Some(sealedUtilTime), Rep.Some(allowAnchor))).shaped.<>({r=>import r._; _1.map(_=> rUserInfo.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column UID SqlType(BIGINT), PrimaryKey */
    val uid: Rep[Long] = column[Long]("UID", O.PrimaryKey)
    /** Database column USER_NAME SqlType(VARCHAR), Length(100,true) */
    val userName: Rep[String] = column[String]("USER_NAME", O.Length(100,varying=true))
    /** Database column PASSWORD SqlType(VARCHAR), Length(100,true) */
    val password: Rep[String] = column[String]("PASSWORD", O.Length(100,varying=true))
    /** Database column ROOMID SqlType(BIGINT), Default(0) */
    val roomid: Rep[Long] = column[Long]("ROOMID", O.Default(0L))
    /** Database column TOKEN SqlType(VARCHAR), Length(63,true), Default() */
    val token: Rep[String] = column[String]("TOKEN", O.Length(63,varying=true), O.Default(""))
    /** Database column TOKEN_CREATE_TIME SqlType(BIGINT) */
    val tokenCreateTime: Rep[Long] = column[Long]("TOKEN_CREATE_TIME")
    /** Database column HEAD_IMG SqlType(VARCHAR), Length(256,true), Default() */
    val headImg: Rep[String] = column[String]("HEAD_IMG", O.Length(256,varying=true), O.Default(""))
    /** Database column COVER_IMG SqlType(VARCHAR), Length(256,true), Default() */
    val coverImg: Rep[String] = column[String]("COVER_IMG", O.Length(256,varying=true), O.Default(""))
    /** Database column EMAIL SqlType(VARCHAR), Length(256,true), Default() */
    val email: Rep[String] = column[String]("EMAIL", O.Length(256,varying=true), O.Default(""))
    /** Database column CREATE_TIME SqlType(BIGINT) */
    val createTime: Rep[Long] = column[Long]("CREATE_TIME")
    /** Database column RTMP_TOKEN SqlType(VARCHAR), Length(256,true), Default() */
    val rtmpToken: Rep[String] = column[String]("RTMP_TOKEN", O.Length(256,varying=true), O.Default(""))
    /** Database column SEALED SqlType(BOOLEAN), Default(false)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `sealed`: Rep[Boolean] = column[Boolean]("SEALED", O.Default(false))
    /** Database column SEALED_UTIL_TIME SqlType(BIGINT), Default(0) */
    val sealedUtilTime: Rep[Long] = column[Long]("SEALED_UTIL_TIME", O.Default(0L))
    /** Database column ALLOW_ANCHOR SqlType(BOOLEAN), Default(true) */
    val allowAnchor: Rep[Boolean] = column[Boolean]("ALLOW_ANCHOR", O.Default(true))

    /** Uniqueness Index over (userName) (database name USER_INFO_USER_NAME_INDEX) */
    val index1 = index("USER_INFO_USER_NAME_INDEX", userName, unique=true)
  }
  /** Collection-like TableQuery object for table tUserInfo */
  lazy val tUserInfo = new TableQuery(tag => new tUserInfo(tag))
}
