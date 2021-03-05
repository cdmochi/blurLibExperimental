package s.pete.blurexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eightbitlab.com.blurview.BlurView
import eightbitlab.com.blurview.RenderScriptBlur
import s.pete.blurexample.data.entity.RoomMember

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<RecyclerView>(R.id.recyclerView)
        val members = mutableListOf(
                RoomMember(R.layout.view_room_reservation_console_item),
                RoomMember(R.layout.view_room_reservation_console_item),
                RoomMember(R.layout.view_room_reservation_console_item)
        )

        val adapter = RoomMemberAdapter(window.decorView)

        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapter.update(members)

//        val targetView = findViewById<BlurView>(R.id.blurView)
//
//        val decoreView : View = window.decorView
//        val rootView: ViewGroup = findViewById(R.id.clRootContainer)
//        val windowBg = decoreView.background
//
//        targetView.setupWith(rootView)
//                .setBlurAlgorithm(RenderScriptBlur(this))
//                .setBlurRadius(20f)
//                .setBlurAutoUpdate(true)
//                .setHasFixedTransformationMatrix(true)
//
//        targetView.outlineProvider = ViewOutlineProvider.BACKGROUND
//        targetView.clipToOutline = true
    }
}