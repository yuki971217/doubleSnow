package org.seekloud.theia.protocol.ptcl.client2Manager.http


import org.seekloud.theia.protocol.ptcl.client2Manager.http.CommonProtocol.InviteeInfo
import org.seekloud.theia.protocol.ptcl.{Request, Response}

/**
  * created by benyafang on 2019/9/23 13:24
  * */
object RecordCommentProtocol {


  case class AddRecordCommentReq(
                                  roomId:Long,//录像的房间id
                                  recordTime:Long,//录像的时间戳
                                  comment:String,
                                  commentTime:Long,//评论的时间
                                  relativeTime:Long,//相对视频的时间
                                  commentUid:Long,//评论的用户id
                                  authorUidOpt:Option[Long] = None//被评论的用户id，None--回复主播
                                ) extends Request

  case class CommentInfo(
                          commentId:Long,//评论的数据库id，可用户拓展删除评论功能
                          roomId:Long,//录像的房间id
                          recordTime:Long,//录像的时间戳
                          comment:String,
                          commentTime:Long,//评论的时间
                          relativeTime:Long,
                          commentUid:Long,//评论的用户id
                          commentUserName:String,//评论用户的昵称
                          commentHeadImgUrl:String,
                          authorUidOpt:Option[Long] = None,//被评论的用户id，None--回复主播
                          authorUserNameOpt:Option[String] = None,
                          authorHeadImgUrl:Option[String] = None
                        )


  case class GetRecordCommentListReq(
                              roomId:Long,//房间id
                              recordTime:Long//录像时间戳
                              )

  case class GetRecordCommentListRsp(
                              recordCommentList:List[CommentInfo],
                              errCode:Int = 0,
                              msg:String = "ok"
                              )extends Response



  case class DeleteCommentReq(
    roomid:Long,
    commentid:Long,
    uid:Long     //执行删除操作的用户id
  )extends Request



}
