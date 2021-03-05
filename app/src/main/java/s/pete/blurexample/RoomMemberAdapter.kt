package s.pete.blurexample

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import eightbitlab.com.blurview.BlurView
import eightbitlab.com.blurview.RenderScriptBlur
import s.pete.blurexample.data.entity.RoomMember

class RoomMemberAdapter(val decoreView: View): RecyclerView.Adapter<RoomMemberAdapter.UserVH>() {

    var list = mutableListOf<RoomMember>()
    inner class UserVH(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val rootContainer = itemView.findViewById<ConstraintLayout>(R.id.clRootContainer)
        private val targetView = itemView.findViewById<BlurView>(R.id.blurView)
        private val userImage = itemView.findViewById<ImageView>(R.id.ivMemberImage)

        fun bind(position: Int) {
            userImage.setImageDrawable(ContextCompat.getDrawable(itemView.context, R.drawable.blurview_background_img_large))
//            targetView.outlineProvider = ViewOutlineProvider.BACKGROUND
//            targetView.clipToOutline = true
        }

        fun blurContainer() {
            targetView
                    .setupWith(rootContainer)
                    .setFrameClearDrawable(decoreView.background)
                    .setBlurAlgorithm(RenderScriptBlur(itemView.context))
                    .setBlurRadius(20f)
                    .setBlurAutoUpdate(true)
                    .setHasFixedTransformationMatrix(false)
        }
    }

    fun update(list: MutableList<RoomMember>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val viewHolder =  with(LayoutInflater.from(parent.context)) {
            UserVH(inflate(R.layout.view_room_reservation_console_item, parent, false))
        }
        viewHolder.blurContainer()
        return viewHolder
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}