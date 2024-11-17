package com.example.mynote

import RecordAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynote.databinding.ActivityWorkBinding

class WorkActivity : AppCompatActivity() {
    private lateinit var binding:ActivityWorkBinding

    private lateinit var recordAdapter: RecordAdapter
    private var recordlist= mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView=binding.recordrv
        recyclerView.layoutManager=LinearLayoutManager(this)
        recordAdapter=RecordAdapter(recordlist)
        recyclerView.adapter=recordAdapter

        val addrecordbtn=binding.addrecordbtn
        addrecordbtn.setOnClickListener{
            val text = binding.newrecordet.text.toString()
            if (text.isNotBlank()){
                recordAdapter.addrecord(text)
                binding.newrecordet.text.clear()
            }
        }

        val exitbtn=binding.exitbtn
        exitbtn.setOnClickListener{
            finishAffinity()
        }
    }

}