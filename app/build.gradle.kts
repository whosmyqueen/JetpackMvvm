plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.ksp)
    alias(libs.plugins.navigation.safeargs) //导航组件 SafeArgs 插件 ,不使用navigation的话，这个插件可以不导入
}

android {
    namespace = "me.hgj.jetpackmvvm.demo"
    compileSdk = 36

    defaultConfig {
        applicationId = "me.hgj.jetpackmvvm.demo"
        minSdk = 23
        targetSdk = 36
        versionCode = 33
        versionName = "2.0.3"
        multiDexEnabled = true
        ndk {
            abiFilters.addAll(listOf("arm64-v8a", "armeabi-v7a"))
        }
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    signingConfigs {
        create("release") {
            storeFile = file("cxk.jks")
            storePassword = "cxk666"
            keyAlias = "kunkun"
            keyPassword = "cxk666"
            enableV1Signing = true
            enableV2Signing = true
        }
    }

    buildTypes {
        named("debug") {
            isMinifyEnabled = false //关闭混淆
            isShrinkResources = false
            signingConfig = signingConfigs.getByName("release") // 签名信息配置
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),"proguard-rules.pro") //混淆规则文件
        }
        named("release") {
            isMinifyEnabled = true //开启混淆
            isShrinkResources = true
            signingConfig = signingConfigs.getByName("release") // 签名信息配置
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),"proguard-rules.pro") //混淆规则文件
        }
    }

    kotlin {
        jvmToolchain(17) // 自动设置 Java 17 兼容性
    }

    lint {
        abortOnError = false
        checkReleaseBuilds = false
    }
}

dependencies {
    //基础库
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.multidex)
    implementation(libs.androidx.swiperefreshlayout)
    implementation(libs.androidx.preference.ktx)
    //暂时弃用
    implementation(libs.androidx.splashscreen)
    // JetpackMvvm 框架不再引入navigation，大家想用navigation的话就自己引入，我这里是历史遗留原因demo之前用的是navigation，所以还是示例引入了
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    //项目核心框架
    implementation(project(":JetpackMvvm"))
//    implementation(libs.jetpackmvvm)

    //网络请求，JetpackMvvm 框架不再内置引入网络框架，大家可以自行选择Retrofit或者其他优秀的第三方网络框架 比如RxHttp，Net等
    //================================网络框架 sart ===========================//

    // rxhttp示例引入((me.hgj.jetpackmvvm.demo.app.core.net.rxhttp 包中))
    implementation(libs.okhttp) //必须
    implementation(libs.rxhttp)
    ksp(libs.rxhttp.compiler)

    //retrofit示例(me.hgj.jetpackmvvm.demo.app.core.net.retrofit 包中)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    //================================网络框架 end ===========================//

    //================================demo项目相关使用到的库 sart ===========================//
    implementation(libs.dialog.bootomsheets)
    //轮播图
    implementation(libs.banner)
    //lottie动画
    implementation(libs.lottie)
    //指示器库
    implementation(libs.magicindicator)
    //加载webview
    implementation(libs.agentweb)
    implementation(libs.filechooser)
    implementation(libs.downloader)
    //RevealLayout 收藏的 红心
    implementation(libs.reveallayout)
    //屏幕适配
    implementation(libs.autosize)
    //防崩溃
    implementation(libs.customactivityoncrash)
    //富文本工具
    implementation(libs.spannable)
    //================================demo项目相关使用到的库 end ===========================//
}