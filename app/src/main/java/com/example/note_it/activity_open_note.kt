package com.example.note_it

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract

class OpenNote : AppCompatActivity() {

    private var binding: ActivityOpenNoteBinding? = null
    private var selectedNote: ContactsContract.CommonDataKinds.Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpenNoteBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        selectedNote = intent.getSerializableExtra("SelectedNote") as ContactsContract.CommonDataKinds.Note

        binding?.llBg?.setBackgroundColor(selectedNote!!.color!!)
        binding?.tvTitleOpen?.text = selectedNote?.title
        binding?.tvDesOpen?.text = selectedNote?.des

        //back button functionality
        binding?.ivBackButton?.setOnClickListener {
            finish()
        }

        binding?.ivEditButton?.setOnClickListener {
            val editNoteIntent = Intent(this, EditNote::class.java)
            editNoteIntent.putExtra("EditSelectedNote", selectedNote)
            startActivity(editNoteIntent)
        }



        binding?.tvTitleOpen?.text = selectedNote?.title
        binding?.tvDesOpen?.text = selectedNote?.des
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}