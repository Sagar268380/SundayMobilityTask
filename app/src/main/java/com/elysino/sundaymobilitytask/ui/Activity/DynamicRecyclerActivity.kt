package com.elysino.sundaymobilitytask.ui.Activity

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elysino.sundaymobilitytask.R
import com.elysino.sundaymobilitytask.contract.ShowUIContract
import com.elysino.sundaymobilitytask.model.DummyParentDataItem
import com.elysino.sundaymobilitytask.model.ShowUIModel
import com.elysino.sundaymobilitytask.presenter.ShowUIPresenter
import com.elysino.sundaymobilitytask.ui.Adapter.RecyclerDataAdapter
import java.util.*

class DynamicRecyclerActivity : AppCompatActivity(), ShowUIContract.View {
    var mRecyclerView: RecyclerView? = null
    var simpleVideoView: VideoView? = null
    var mediaControls: MediaController? = null
    var recyclerDataAdapter: RecyclerDataAdapter? = null
    var presenter: ShowUIContract.Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_recycler)
        setUpUiElements()
        presenter = ShowUIPresenter(ShowUIModel(), this)
        presenter?.start()
        VideoPlay()
    }

    fun setUpUiElements() {
        simpleVideoView = findViewById(R.id.simpleVideoView)
        mRecyclerView = findViewById(R.id.recyclerView)
        recyclerDataAdapter = RecyclerDataAdapter(this)
        mRecyclerView?.layoutManager = LinearLayoutManager(this)
        mRecyclerView?.adapter = recyclerDataAdapter
        mRecyclerView?.setHasFixedSize(true)
    }

    private fun VideoPlay() {
        if (mediaControls == null) {
            mediaControls = MediaController(this@DynamicRecyclerActivity)
            mediaControls?.setAnchorView(simpleVideoView)
        }
        val localUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.sample)
        simpleVideoView?.setVideoURI(localUri)
        simpleVideoView?.setMediaController(mediaControls)
        simpleVideoView?.start()
        simpleVideoView?.setOnCompletionListener {
            Toast.makeText(applicationContext, "Thank You...!!!", Toast.LENGTH_LONG).show() // display a toast when an video is completed
        }
        simpleVideoView?.setOnErrorListener { mp: MediaPlayer?, what: Int, extra: Int ->
            Toast.makeText(applicationContext, "Oops An Error Occur While Playing Video...!!!", Toast.LENGTH_LONG).show() // display a toast when an error is occured while playing an video
            false
        }
    }

    override fun addItems(arrayList: ArrayList<DummyParentDataItem?>?) {
        recyclerDataAdapter?.addItems(arrayList)
    }

    override val isActive: Boolean
        get() = !isFinishing
}