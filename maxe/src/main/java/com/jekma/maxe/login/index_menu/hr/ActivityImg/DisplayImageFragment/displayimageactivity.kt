package com.company.maxe.Login.index_menu.hr.ActivityImg.DisplayImageFragment

import com.jekma.baselibrary.BaseFragment
import com.jekma.maxe.R
//import com.bumptech.glide.Glide

class displayimageactivity :BaseFragment() {
    //    private var downloadImageFromURL: AsyncTask<String, String, String>? = null
//    private val TAG = "displayimageactivity"
//    private var controlPanelUp: LinearLayout? = null
//    private var controlPanelDown: LinearLayout? = null
//    private var path // 圖片網址(陣列)
//            : Array<String>
//    private var currentPosition //當前位置
//            = 0
//    private var adapter: ViewPagerAdapter? = null
//    private var viewPager: ViewPager? = null
//    private var photoView: PhotoView? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_displayimageactivity)
//        val bundle: Bundle? = intent.extras
//        supportActionBar!!.hide() //hide title bar
//        if (bundle != null) {
//            path = bundle.getStringArray("id") //姓名
//            currentPosition = bundle.getInt("currentPosition") //當前索引直
//            viewPager = findViewById<ViewPager>(R.id.view_pager)
//            adapter = ViewPagerAdapter(this, path)
//            viewPager.setAdapter(adapter)
//            viewPager.setCurrentItem(currentPosition)
//            ListeningElement()
//        }
//        else {
//            Log.wtf(TAG, "Bundle is empty")
//        }
//    }
//
//    /**
//     * 接住XML所有的元件並加入事件
//     */
//    private fun ListeningElement() {
//        controlPanelUp = findViewById<LinearLayout>(R.id.controlPanelUp)
//        controlPanelDown = findViewById<LinearLayout>(R.id.controlPanelDown)
//        controlPanelUp.setVisibility(View.VISIBLE)
//        controlPanelDown.setVisibility(View.VISIBLE)
//        val Back = findViewById<ImageView>(R.id.Back)
//        val share = findViewById<ImageView>(R.id.share)
//        val download = findViewById<ImageView>(R.id.download)
//        Back.setOnClickListener(this)
//        share.setOnClickListener(this)
//        download.setOnClickListener(this)
//    }
//
//    /**
//     * @param v
//     * 表層的功能監聽事件
//     * @variable R.id.Back     為 返回上一頁
//     * @variable R.id.share    為 分享圖片 share()
//     * @variable R.id.download 為 下載圖片 download()
//     */
//    override fun onClick(v: View) {
//        val id = v as ImageView
//        when (id.id) {
//            R.id.Back     -> finish()
//            R.id.share    -> share()
//            R.id.download -> download()
//            else          -> {}
//        }
//    }
//
//    //下載事件
//    private fun download() {
//        //檢查是否取得權限
//        val permissionCheck =
//            ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
//            //還沒獲取權限要做什麼呢
//            //和使用者要求權限
//            ActivityCompat.requestPermissions(this@displayimageactivity, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
//            //                    Toast.makeText(this, "尚未拿到權限囉!", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            //已獲取權限要做的事情
//            downloadImageFromURL =
//                DownloadImageFromURL().execute(photoView.getTag(R.id.Selected_photo).toString())
//        }
//    }
//
//    //分享事件
//    private fun share() {
//        val shareIntent = Intent(Intent.ACTION_SEND)
//        shareIntent.setType("text/plain")
//        val shareBody = path[viewPager.getCurrentItem()]
//        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
//        startActivity(Intent.createChooser(shareIntent, "Share Using"))
//    }
//
//    /**
//     * 使用ViewPager 搭配 photoview，實作 上一張(往左滑)，下一張圖片(往右滑)
//     */
//    private inner class ViewPagerAdapter internal constructor(private val context: Context, private val imageUrls: Array<String>) :
//        PagerAdapter() {
//        override fun getCount(): Int {
//            return imageUrls.size
//        }
//
//        override fun isViewFromObject(view: View, `object`: Any): Boolean {
//            return view === `object`
//        }
//
//        override fun instantiateItem(container: ViewGroup, position: Int): Any {
//            photoView = PhotoView(context)
//            Glide.with(context).load(imageUrls[position]).into(photoView)
//            photoView.setOnPhotoTapListener(object : OnPhotoTapListener() {
//                fun onPhotoTap(view: ImageView?, x: Float, y: Float) {
//                    println("single tap")
//                    if (controlPanelUp.getVisibility() == View.VISIBLE) {
//                        controlPanelUp.setVisibility(View.INVISIBLE)
//                    }
//                    else {
//                        controlPanelUp.setVisibility(View.VISIBLE)
//                    }
//                    if (controlPanelDown.getVisibility() == View.VISIBLE) {
//                        controlPanelDown.setVisibility(View.INVISIBLE)
//                    }
//                    else {
//                        controlPanelDown.setVisibility(View.VISIBLE)
//                    }
//                }
//            })
//            photoView.setTag(R.id.Selected_photo, imageUrls[viewPager.getCurrentItem()])
//            container.addView(photoView)
//            return photoView
//        }
//
//        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//            container.removeView(`object` as View)
//        }
//    }
//
//    /**
//     * 使用AsyncTask 實作
//     * 下載照片，並放到系統資料夾裡面，並廣播通知系統更新
//     */
//    private inner class DownloadImageFromURL : AsyncTask<String?, String?, String?>() {
//        private var pDialog: ProgressDialog? = null
//        protected override fun onPostExecute(file_url: String) {
//            Toast.makeText(this@displayimageactivity, "下載成功", Toast.LENGTH_SHORT).show()
//            pDialog.dismiss()
//        }
//
//        /**
//         * Before starting background thread
//         */
//        protected override fun onPreExecute() {
//            super.onPreExecute()
//            println("Starting download")
//            pDialog = ProgressDialog(this@displayimageactivity)
//            pDialog.setMessage("下載中... 請稍後...")
//            pDialog.setIndeterminate(false)
//            pDialog.setCancelable(true)
//            pDialog.setCanceledOnTouchOutside(true)
//            pDialog.setOnCancelListener(object : DialogInterface.OnCancelListener {
//                override fun onCancel(dialog: DialogInterface) {
//                    Toast.makeText(this@displayimageactivity, "已取消下載", Toast.LENGTH_SHORT).show()
//                    downloadImageFromURL.cancel(true)
//                    return
//                }
//            })
//            pDialog.show()
//        }
//
//        /**
//         * ------因Google在Android 10更新了系統資料夾的權限，故分開處理
//         * ------SDK版本 > Api 29 (目前尚未完成)
//         * ------SDK版本 < Api 29 (已完成)
//         */
//        protected override fun doInBackground(vararg f_url: String): String {
//            if (!isCancelled()) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//                    //Higher or Equal Android 10
//                    saveImageToGalleryHigherAndroid10(this@displayimageactivity, getBitmapFromURL(f_url[0]), "demo")
//                }
//                else {
//                    //Below Android 10
//                    saveImageToGalleryBelowAndroid10(this@displayimageactivity, getBitmapFromURL(f_url[0]))
//                }
//            }
//            else {
//            }
//            return null
//        }
//
//        private fun getBitmapFromURL(src: String): Bitmap? {
//            return try {
//                val url = URL(src)
//                val connection = url.openConnection() as HttpURLConnection
//                connection.doInput = true
//                connection.connect()
//                val input = connection.inputStream
//                BitmapFactory.decodeStream(input)
//            } catch (e: IOException) {
//                // Log exception
//                null
//            }
//        }
//
//        private fun saveImageToGalleryBelowAndroid10(context: Context, bmp: Bitmap?): Boolean {
//            val storePath =
//                Environment.getExternalStorageDirectory().absolutePath + File.separator + "Maxe"
//            val appDir = File(storePath)
//            if (!appDir.exists()) {
//                appDir.mkdir()
//            }
//            val fileName = System.currentTimeMillis().toString() + ".jpg"
//            val file = File(appDir, fileName)
//            try {
//                val fos = FileOutputStream(file)
//                val isSuccess: Boolean = bmp.compress(Bitmap.CompressFormat.JPEG, 60, fos)
//                fos.flush()
//                fos.close()
//                val uri = Uri.fromFile(file)
//                context.sendBroadcast(Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri))
//                return if (isSuccess) {
//                    true
//                }
//                else {
//                    false
//                }
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//            return false
//        }
//
//        private fun saveImageToGalleryHigherAndroid10(context: Context, bmp: Bitmap?, filename: String) {
//            try {
//                val fos: OutputStream
//                val resolver: ContentResolver = context.contentResolver
//                val contentValues = ContentValues()
//                contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, "$filename.jpg")
//                contentValues.put(MediaStore.Images.Media.MIME_TYPE, "image/jpg")
//                contentValues.put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + File.separator + "Maxe")
//                val ImageUri: Uri =
//                    resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
//                fos = resolver.openOutputStream(ImageUri)
//                bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos)
//                fos.close()
//            } catch (e: FileNotFoundException) {
//                e.printStackTrace()
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//        }
//    }
    override val titleResId: Int
        get() = R.string.maxe_title_displayimageactivity
    override val layoutResId: Int
        get() = R.layout.maxe_fragment_displayimageactivity
}