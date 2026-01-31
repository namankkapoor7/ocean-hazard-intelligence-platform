plugins {
	java
	// 🛑 CRITICAL FIX: Changed inva@file:OptIn(ExperimentalMaterial3Api::class)
	//
	//package com.example.myapplication
	//
	//import android.os.Bundle
	//import androidx.activity.ComponentActivity
	//import androidx.activity.compose.setContent
	//import androidx.compose.foundation.BorderStroke
	//import androidx.compose.foundation.Canvas
	//import androidx.compose.foundation.background
	//import androidx.compose.foundation.clickable
	//import androidx.compose.foundation.layout.*
	//import androidx.compose.foundation.lazy.LazyColumn
	//import androidx.compose.foundation.lazy.items
	//import androidx.compose.foundation.shape.RoundedCornerShape
	//import androidx.compose.material.icons.Icons
	//import androidx.compose.material.icons.filled.*
	//import androidx.compose.material3.*
	//import androidx.compose.runtime.*
	//import androidx.compose.ui.Alignment
	//import androidx.compose.ui.Modifier
	//import androidx.compose.ui.graphics.Color
	//import androidx.compose.ui.graphics.Path
	//import androidx.compose.ui.graphics.StrokeCap
	//import androidx.compose.ui.graphics.drawscope.Stroke
	//import androidx.compose.ui.text.font.FontWeight
	//import androidx.compose.ui.text.input.PasswordVisualTransformation
	//import androidx.compose.ui.text.input.VisualTransformation
	//import androidx.compose.ui.tooling.preview.Preview
	//import androidx.compose.ui.unit.dp
	//import androidx.compose.ui.unit.sp
	//
	//// -------------------------------------------------------
	//// DATA
	//// -------------------------------------------------------
	//data class HazardResponse(
	//    val text: String,
	//    val hazard_label: Int,
	//    val sentiment: String,
	//    val keywords: List<String>
	//)
	//
	//val hazardData = listOf(
	//    HazardResponse("Huge waves rising fast!", 1, "fear", listOf("huge waves", "rising fast")),
	//    HazardResponse("Beautiful calm day", 0, "positive", listOf("beach", "calm")),
	//    HazardResponse("Sea water entering the road", 1, "fear", listOf("sea water", "road")),
	//    HazardResponse("Strong winds causing rough sea", 1, "alert", listOf("winds", "rough sea"))
	//)
	//
	//sealed class Screen {
	//    object Dashboard : Screen()
	//    object Analysis : Screen()
	//    object HazardList : Screen()
	//    object Profile : Screen()
	//}
	//
	//// -------------------------------------------------------
	//// MAIN ACTIVITY
	//// -------------------------------------------------------
	//class MainActivity : ComponentActivity() {
	//    override fun onCreate(savedInstanceState: Bundle?) {
	//        super.onCreate(savedInstanceState)
	//        setContent {
	//            MaterialTheme(colorScheme = darkColorScheme()) {
	//                ApdaSetuApp()
	//            }
	//        }
	//    }
	//}
	//
	//// -------------------------------------------------------
	//// APP ROOT
	//// -------------------------------------------------------
	//@Composable
	//fun ApdaSetuApp() {
	//    var loggedIn by remember { mutableStateOf(false) }
	//    var showLogin by remember { mutableStateOf(true) }
	//    var username by remember { mutableStateOf("User") }
	//    var screen by remember { mutableStateOf<Screen>(Screen.Dashboard) }
	//
	//    if (!loggedIn) {
	//        if (showLogin) {
	//            LoginScreen(
	//                onLogin = { name ->
	//                    username = name
	//                    loggedIn = true
	//                },
	//                onClickRegister = { showLogin = false }
	//            )
	//        } else {
	//            RegisterScreen(
	//                onRegister = { name ->
	//                    username = name
	//                    loggedIn = true
	//                },
	//                onClickLogin = { showLogin = true }
	//            )
	//        }
	//    } else {
	//        MainNavigation(
	//            screen = screen,
	//            username = username,
	//            onScreenChange = { screen = it },
	//            onLogout = {
	//                loggedIn = false
	//                showLogin = true
	//            }
	//        )
	//    }
	//}
	//
	//// -------------------------------------------------------
	//// LOGIN SCREEN
	//// -------------------------------------------------------
	//@Composable
	//fun LoginScreen(
	//    onLogin: (String) -> Unit,
	//    onClickRegister: () -> Unit
	//) {
	//    var name by remember { mutableStateOf("") }
	//    var pwd by remember { mutableStateOf("") }
	//    var visible by remember { mutableStateOf(false) }
	//    var error by remember { mutableStateOf("") }
	//
	//    Box(
	//        modifier = Modifier
	//            .fillMaxSize()
	//            .background(Color(0xFF020617)),
	//        contentAlignment = Alignment.Center
	//    ) {
	//        Card(
	//            modifier = Modifier.fillMaxWidth(0.9f),
	//            colors = CardDefaults.cardColors(Color(0xFF0F172A)),
	//            shape = RoundedCornerShape(16.dp)
	//        ) {
	//            Column(
	//                modifier = Modifier.padding(24.dp),
	//                horizontalAlignment = Alignment.CenterHorizontally,
	//                verticalArrangement = Arrangement.spacedBy(12.dp)
	//            ) {
	//                Text(
	//                    "Apda Setu",
	//                    fontSize = 28.sp,
	//                    fontWeight = FontWeight.Bold,
	//                    color = Color(0xFF38BDF8)
	//                )
	//                Text("Login", fontSize = 20.sp)
	//
	//                OutlinedTextField(
	//                    value = name,
	//                    onValueChange = { name = it; error = "" },
	//                    modifier = Modifier.fillMaxWidth(),
	//                    label = { Text("Username") }
	//                )
	//
	//                OutlinedTextField(
	//                    value = pwd,
	//                    onValueChange = { pwd = it; error = "" },
	//                    modifier = Modifier.fillMaxWidth(),
	//                    label = { Text("Password") },
	//                    visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
	//                    trailingIcon = {
	//                        IconButton(onClick = { visible = !visible }) {
	//                            Icon(
	//                                if (visible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
	//                                null
	//                            )
	//                        }
	//                    }
	//                )
	//
	//                Button(
	//                    onClick = {
	//                        if (name.isNotBlank() && pwd.isNotBlank()) onLogin(name)
	//                        else error = "Username & password cannot be empty."
	//                    },
	//                    modifier = Modifier.fillMaxWidth()
	//                ) { Text("Login") }
	//
	//                if (error.isNotEmpty()) {
	//                    Text(error, color = Color.Red, fontSize = 12.sp)
	//                }
	//
	//                Text(
	//                    "Don't have an account? Register",
	//                    modifier = Modifier.clickable { onClickRegister() },
	//                    color = Color(0xFF38BDF8)
	//                )
	//            }
	//        }
	//    }
	//}
	//
	//// -------------------------------------------------------
	//// REGISTER SCREEN
	//// -------------------------------------------------------
	//@Composable
	//fun RegisterScreen(
	//    onRegister: (String) -> Unit,
	//    onClickLogin: () -> Unit
	//) {
	//    var name by remember { mutableStateOf("") }
	//    var email by remember { mutableStateOf("") }
	//    var pwd by remember { mutableStateOf("") }
	//    var visible by remember { mutableStateOf(false) }
	//    var error by remember { mutableStateOf("") }
	//
	//    Box(
	//        modifier = Modifier
	//            .fillMaxSize()
	//            .background(Color(0xFF020617)),
	//        contentAlignment = Alignment.Center
	//    ) {
	//        Card(
	//            modifier = Modifier.fillMaxWidth(0.9f),
	//            colors = CardDefaults.cardColors(Color(0xFF0F172A)),
	//            shape = RoundedCornerShape(16.dp)
	//        ) {
	//            Column(
	//                modifier = Modifier.padding(24.dp),
	//                horizontalAlignment = Alignment.CenterHorizontally,
	//                verticalArrangement = Arrangement.spacedBy(12.dp)
	//            ) {
	//                Text(
	//                    "Apda Setu",
	//                    fontSize = 28.sp,
	//                    fontWeight = FontWeight.Bold,
	//                    color = Color(0xFF38BDF8)
	//                )
	//                Text("Register", fontSize = 20.sp)
	//
	//                OutlinedTextField(
	//                    value = name,
	//                    onValueChange = { name = it; error = "" },
	//                    label = { Text("Full Name") },
	//                    modifier = Modifier.fillMaxWidth()
	//                )
	//                OutlinedTextField(
	//                    value = email,
	//                    onValueChange = { email = it; error = "" },
	//                    label = { Text("Email") },
	//                    modifier = Modifier.fillMaxWidth()
	//                )
	//
	//                OutlinedTextField(
	//                    value = pwd,
	//                    onValueChange = { pwd = it; error = "" },
	//                    modifier = Modifier.fillMaxWidth(),
	//                    label = { Text("Password") },
	//                    visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
	//                    trailingIcon = {
	//                        IconButton(onClick = { visible = !visible }) {
	//                            Icon(
	//                                if (visible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
	//                                null
	//                            )
	//                        }
	//                    }
	//                )
	//
	//                Button(
	//                    onClick = {
	//                        if (name.isNotBlank() && email.isNotBlank() && pwd.isNotBlank()) onRegister(name)
	//                        else error = "All fields are required."
	//                    },
	//                    modifier = Modifier.fillMaxWidth()
	//                ) { Text("Create Account") }
	//
	//                if (error.isNotEmpty()) {
	//                    Text(error, color = Color.Red, fontSize = 12.sp)
	//                }
	//
	//                Text(
	//                    "Already have an account? Login",
	//                    modifier = Modifier.clickable { onClickLogin() },
	//                    color = Color(0xFF38BDF8)
	//                )
	//            }
	//        }
	//    }
	//}
	//
	//// -------------------------------------------------------
	//// NAVIGATION + SCREENS
	//// -------------------------------------------------------
	//@Composable
	//fun MainNavigation(
	//    screen: Screen,
	//    username: String,
	//    onScreenChange: (Screen) -> Unit,
	//    onLogout: () -> Unit
	//) {
	//    var menuExpand by remember { mutableStateOf(false) }
	//    var supportDialog by remember { mutableStateOf(false) }
	//
	//    Scaffold(
	//        topBar = {
	//            TopAppBar(
	//                title = {},
	//                colors = TopAppBarDefaults.topAppBarColors(Color(0xFF020617)),
	//                actions = {
	//                    if (screen is Screen.Profile) {
	//                        IconButton(onClick = { menuExpand = true }) {
	//                            Icon(Icons.Default.MoreVert, null)
	//                        }
	//                        DropdownMenu(
	//                            expanded = menuExpand,
	//                            onDismissRequest = { menuExpand = false }
	//                        ) {
	//                            DropdownMenuItem(
	//                                text = { Text("Support") },
	//                                onClick = { supportDialog = true; menuExpand = false }
	//                            )
	//                            DropdownMenuItem(
	//                                text = { Text("Logout") },
	//                                onClick = { onLogout(); menuExpand = false }
	//                            )
	//                        }
	//                    }
	//                }
	//            )
	//        },
	//        bottomBar = {
	//            NavigationBar(containerColor = Color(0xFF020617)) {
	//
	//                NavigationBarItem(
	//                    selected = screen is Screen.Dashboard,
	//                    onClick = { onScreenChange(Screen.Dashboard) },
	//                    icon = { Icon(Icons.Default.Home, null) },
	//                    label = { Text("Dashboard") }
	//                )
	//
	//                NavigationBarItem(
	//                    selected = screen is Screen.HazardList,
	//                    onClick = { onScreenChange(Screen.HazardList) },
	//                    icon = { Icon(Icons.Default.List, null) },
	//                    label = { Text("Hazards") }
	//                )
	//
	//                NavigationBarItem(
	//                    selected = screen is Screen.Profile,
	//                    onClick = { onScreenChange(Screen.Profile) },
	//                    icon = { Icon(Icons.Default.Person, null) },
	//                    label = { Text("Profile") }
	//                )
	//            }
	//        }
	//    ) {
	//        Box(
	//            Modifier
	//                .fillMaxSize()
	//                .padding(it)
	//                .background(Color(0xFF020617))
	//        ) {
	//            when (screen) {
	//                Screen.Dashboard -> DashboardScreen(hazardData) { onScreenChange(Screen.Analysis) }
	//                Screen.Analysis -> DetailedAnalysisScreen(hazardData)
	//                Screen.HazardList -> HazardListScreen(hazardData)
	//                Screen.Profile -> ProfileScreen(username)
	//            }
	//
	//            if (supportDialog) {
	//                AlertDialog(
	//                    onDismissRequest = { supportDialog = false },
	//                    confirmButton = {
	//                        TextButton(onClick = { supportDialog = false }) {
	//                            Text("OK")
	//                        }
	//                    },
	//                    title = { Text("Support") },
	//                    text = { Text("📧 support@apdasetu.com\n📞 +91-XXXXXXXXXX") }
	//                )
	//            }
	//        }
	//    }
	//}
	//
	//// ---------------------------------------------------------------------
	//// DASHBOARD SCREEN (Fear / Positive / Neutral, no pie chart)
	//// ---------------------------------------------------------------------
	//@Composable
	//fun DashboardScreen(
	//    data: List<HazardResponse>,
	//    onViewDetailed: () -> Unit
	//) {
	//    val total = data.size
	//    val highRisk = data.count { it.hazard_label == 1 }
	//    val fearCount = data.count {
	//        it.sentiment.equals("fear", true) || it.sentiment.equals("panic", true)
	//    }
	//    val fearPercent = if (total > 0) fearCount * 100 / total else 0
	//
	//    val sentimentCounts = mutableMapOf(
	//        "Fear" to 0,
	//        "Positive" to 0,
	//        "Neutral" to 0
	//    )
	//
	//    data.forEach {
	//        when (it.sentiment.lowercase()) {
	//            "fear", "panic" ->
	//                sentimentCounts["Fear"] = sentimentCounts["Fear"]!! + 1
	//
	//            "positive", "relief", "calm", "good", "safe" ->
	//                sentimentCounts["Positive"] = sentimentCounts["Positive"]!! + 1
	//
	//            else -> // alert, concern, neutral, negative etc.
	//                sentimentCounts["Neutral"] = sentimentCounts["Neutral"]!! + 1
	//        }
	//    }
	//
	//    val trendValues = listOf(12, 20, 18, 30, 25, 40, 32)
	//
	//    Column(
	//        modifier = Modifier
	//            .fillMaxSize()
	//            .padding(16.dp),
	//        verticalArrangement = Arrangement.spacedBy(18.dp)
	//    ) {
	//
	//        Card(
	//            modifier = Modifier.fillMaxWidth(),
	//            colors = CardDefaults.cardColors(Color(0xFF0F172A)),
	//            shape = RoundedCornerShape(16.dp),
	//            border = BorderStroke(1.dp, Color(0xFF4B5563))
	//        ) {
	//            Column(
	//                modifier = Modifier
	//                    .fillMaxWidth()
	//                    .padding(vertical = 16.dp, horizontal = 20.dp),
	//                verticalArrangement = Arrangement.spacedBy(12.dp)
	//            ) {
	//                Text(
	//                    text = "🔷 Ocean Hazard Monitoring Dashboard",
	//                    fontSize = 15.sp,
	//                    fontWeight = FontWeight.SemiBold,
	//                    color = Color(0xFF38BDF8)
	//                )
	//
	//                Divider(color = Color(0xFF374151))
	//
	//                MetricRow("Hazard Posts Detected Today:", total.toString())
	//                MetricRow("High-Risk Posts:", highRisk.toString())
	//                MetricRow("Fear Sentiment %:", "$fearPercent%")
	//
	//                Spacer(Modifier.height(8.dp))
	//
	//                Text(
	//                    text = "[ View Detailed Reports ]",
	//                    color = Color(0xFFF97373),
	//                    fontWeight = FontWeight.SemiBold,
	//                    modifier = Modifier.clickable { onViewDetailed() }
	//                )
	//            }
	//        }
	//
	//        // BAR CHART CARD
	//        Card(
	//            modifier = Modifier.fillMaxWidth(),
	//            colors = CardDefaults.cardColors(Color(0xFF0F172A)),
	//            shape = RoundedCornerShape(14.dp)
	//        ) {
	//            Column(
	//                modifier = Modifier
	//                    .fillMaxWidth()
	//                    .padding(horizontal = 14.dp, vertical = 16.dp),
	//                verticalArrangement = Arrangement.spacedBy(12.dp)
	//            ) {
	//                Text(
	//                    text = "📊 Sentiment Distribution",
	//                    fontSize = 15.sp,
	//                    fontWeight = FontWeight.Bold,
	//                    color = Color(0xFF38BDF8)
	//                )
	//
	//                Box(
	//                    modifier = Modifier
	//                        .fillMaxWidth()
	//                        .height(180.dp)
	//                ) {
	//                    SentimentBarChart(sentimentCounts)
	//                }
	//            }
	//        }
	//
	//        // LINE CHART
	//        Card(
	//            modifier = Modifier.fillMaxWidth(),
	//            colors = CardDefaults.cardColors(Color(0xFF0F172A)),
	//            shape = RoundedCornerShape(14.dp)
	//        ) {
	//            Column(Modifier.padding(14.dp)) {
	//                Text("Hazard post trend", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
	//                Spacer(Modifier.height(10.dp))
	//                HazardTrendLineChart(trendValues)
	//            }
	//        }
	//
	//        Spacer(Modifier.height(80.dp)) // keep clear of bottom bar
	//    }
	//}
	//
	//@Composable
	//fun MetricRow(label: String, value: String) {
	//    Row(
	//        modifier = Modifier.fillMaxWidth(),
	//        horizontalArrangement = Arrangement.SpaceBetween
	//    ) {
	//        Text(label, fontSize = 14.sp)
	//        Text("[   $value   ]", fontSize = 14.sp, color = Color(0xFFF472B6))
	//    }
	//}
	//
	//// ---------------------------------------------------------------------
	//// DETAILED ANALYSIS (Fear / Positive / Neutral)
	//// ---------------------------------------------------------------------
	//@Composable
	//fun DetailedAnalysisScreen(data: List<HazardResponse>) {
	//
	//    val total = data.size
	//    val hazard = data.count { it.hazard_label == 1 }
	//    val safe = total - hazard
	//
	//    val sentimentCounts = mutableMapOf(
	//        "Fear" to 0,
	//        "Positive" to 0,
	//        "Neutral" to 0
	//    )
	//    val keywordCounts = mutableMapOf<String, Int>()
	//
	//    data.forEach { item ->
	//        val normalizedSentiment = when (item.sentiment.lowercase()) {
	//            "fear", "panic" -> "Fear"
	//            "positive", "relief", "calm", "good", "safe" -> "Positive"
	//            else -> "Neutral"
	//        }
	//        sentimentCounts[normalizedSentiment] = sentimentCounts[normalizedSentiment]!! + 1
	//
	//        item.keywords.forEach { kw ->
	//            keywordCounts[kw] = (keywordCounts[kw] ?: 0) + 1
	//        }
	//    }
	//
	//    val sortedKeywords = keywordCounts.entries.sortedByDescending { it.value }
	//
	//    LazyColumn(
	//        modifier = Modifier
	//            .fillMaxSize()
	//            .padding(16.dp),
	//        verticalArrangement = Arrangement.spacedBy(14.dp),
	//        contentPadding = PaddingValues(bottom = 80.dp)
	//    ) {
	//
	//        item {
	//            Card(
	//                modifier = Modifier.fillMaxWidth(),
	//                colors = CardDefaults.cardColors(Color(0xFF0F172A)),
	//                shape = RoundedCornerShape(16.dp),
	//                border = BorderStroke(1.dp, Color(0xFF4B5563))
	//            ) {
	//                Column(
	//                    Modifier.padding(16.dp),
	//                    verticalArrangement = Arrangement.spacedBy(6.dp)
	//                ) {
	//                    Text("📊 Detailed Hazard Analysis", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
	//                    Text("Total posts: $total", fontSize = 13.sp)
	//                    Text("Hazard posts: $hazard", fontSize = 13.sp, color = Color(0xFFEF4444))
	//                    Text("Safe posts: $safe", fontSize = 13.sp, color = Color(0xFF22C55E))
	//                }
	//            }
	//        }
	//
	//        item {
	//            Card(
	//                modifier = Modifier.fillMaxWidth(),
	//                colors = CardDefaults.cardColors(Color(0xFF0F172A)),
	//                shape = RoundedCornerShape(16.dp)
	//            ) {
	//                Column(
	//                    Modifier.padding(16.dp),
	//                    verticalArrangement = Arrangement.spacedBy(6.dp)
	//                ) {
	//                    Text("Sentiment breakdown", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
	//
	//                    sentimentCounts.forEach { (sent, count) ->
	//                        Row(
	//                            Modifier.fillMaxWidth(),
	//                            horizontalArrangement = Arrangement.SpaceBetween
	//                        ) {
	//                            Text(sent, fontSize = 13.sp)
	//                            Text(count.toString(), fontSize = 13.sp, color = Color(0xFF9CA3AF))
	//                        }
	//                    }
	//                }
	//            }
	//        }
	//
	//        item {
	//            Card(
	//                modifier = Modifier.fillMaxWidth(),
	//                colors = CardDefaults.cardColors(Color(0xFF0F172A)),
	//                shape = RoundedCornerShape(16.dp)
	//            ) {
	//                Column(
	//                    Modifier.padding(16.dp),
	//                    verticalArrangement = Arrangement.spacedBy(6.dp)
	//                ) {
	//                    Text("Top keywords", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
	//
	//                    sortedKeywords.forEach { (word, count) ->
	//                        Row(
	//                            Modifier.fillMaxWidth(),
	//                            horizontalArrangement = Arrangement.SpaceBetween
	//                        ) {
	//                            Text(word, fontSize = 13.sp)
	//                            Text(count.toString(), fontSize = 13.sp, color = Color(0xFF9CA3AF))
	//                        }
	//                    }
	//                }
	//            }
	//        }
	//    }
	//}
	//
	//// ---------------------------------------------------------------------
	//// GRAPHS
	//// ---------------------------------------------------------------------
	//@Composable
	//fun SentimentBarChart(sentiments: Map<String, Int>) {
	//    val maxValue = sentiments.values.maxOrNull()?.takeIf { it > 0 } ?: 1
	//
	//    Row(
	//        modifier = Modifier.fillMaxWidth(),
	//        horizontalArrangement = Arrangement.SpaceEvenly,
	//        verticalAlignment = Alignment.Bottom
	//    ) {
	//        sentiments.forEach { (label, value) ->
	//
	//            val fraction = (value.toFloat() / maxValue).coerceIn(0f, 1f)
	//
	//            Column(
	//                modifier = Modifier.height(180.dp),
	//                horizontalAlignment = Alignment.CenterHorizontally
	//            ) {
	//                Box(
	//                    modifier = Modifier
	//                        .width(32.dp)
	//                        .height(120.dp)
	//                ) {
	//                    Box(
	//                        modifier = Modifier
	//                            .fillMaxWidth()
	//                            .fillMaxHeight(fraction)
	//                            .align(Alignment.BottomCenter)
	//                            .background(Color(0xFF38BDF8), RoundedCornerShape(6.dp))
	//                    )
	//                }
	//
	//                Spacer(modifier = Modifier.height(6.dp))
	//
	//                Text(
	//                    text = label,
	//                    fontSize = 14.sp,
	//                    fontWeight = FontWeight.Bold,
	//                    color = Color.White
	//                )
	//
	//                Text(
	//                    text = value.toString(),
	//                    fontSize = 12.sp,
	//                    color = Color(0xFF9CA3AF)
	//                )
	//            }
	//        }
	//    }
	//}
	//
	//@Composable
	//fun HazardTrendLineChart(values: List<Int>) {
	//    val maxValue = (values.maxOrNull() ?: 1).toFloat()
	//
	//    Canvas(
	//        modifier = Modifier
	//            .fillMaxWidth()
	//            .height(140.dp)
	//    ) {
	//        if (values.isEmpty()) return@Canvas
	//
	//        val stepX = if (values.size == 1) size.width else size.width / (values.size - 1)
	//        val path = Path()
	//
	//        values.forEachIndexed { index, v ->
	//            val x = stepX * index
	//            val ratio = v.toFloat() / maxValue
	//            val y = size.height - (ratio * size.height)
	//
	//            if (index == 0) path.moveTo(x, y) else path.lineTo(x, y)
	//        }
	//
	//        drawPath(
	//            path = path,
	//            color = Color(0xFF38BDF8),
	//            style = Stroke(width = 4f, cap = StrokeCap.Round)
	//        )
	//    }
	//}
	//
	//// ---------------------------------------------------------------------
	//// HAZARD POST LIST (Fear / Positive / Neutral)
	//// ---------------------------------------------------------------------
	//@Composable
	//fun HazardListScreen(posts: List<HazardResponse>) {
	//
	//    val sentimentCounts = posts.groupingBy {
	//        when (it.sentiment.lowercase()) {
	//            "fear", "panic" -> "Fear"
	//            "positive", "relief", "calm", "good", "safe" -> "Positive"
	//            else -> "Neutral"
	//        }
	//    }.eachCount()
	//
	//    Column(
	//        modifier = Modifier
	//            .fillMaxSize()
	//            .padding(16.dp),
	//        verticalArrangement = Arrangement.spacedBy(16.dp)
	//    ) {
	//
	//        Card(
	//            modifier = Modifier.fillMaxWidth(),
	//            colors = CardDefaults.cardColors(Color(0xFF0F172A)),
	//            shape = RoundedCornerShape(16.dp),
	//            border = BorderStroke(1.dp, Color(0xFF4B5563))
	//        ) {
	//            Column(
	//                modifier = Modifier
	//                    .fillMaxWidth()
	//                    .padding(14.dp),
	//                horizontalAlignment = Alignment.CenterHorizontally
	//            ) {
	//                Text(
	//                    text = "🔥 Hazard Related Posts",
	//                    fontSize = 18.sp,
	//                    fontWeight = FontWeight.Bold
	//                )
	//
	//                Spacer(modifier = Modifier.height(8.dp))
	//
	//                Text(
	//                    "Fear: ${sentimentCounts["Fear"] ?: 0}   |   Positive: ${sentimentCounts["Positive"] ?: 0}   |   Neutral: ${sentimentCounts["Neutral"] ?: 0}",
	//                    fontSize = 14.sp,
	//                    color = Color(0xFF38BDF8)
	//                )
	//            }
	//        }
	//
	//        LazyColumn(
	//            modifier = Modifier.fillMaxSize(),
	//            verticalArrangement = Arrangement.spacedBy(12.dp),
	//            contentPadding = PaddingValues(bottom = 80.dp)
	//        ) {
	//            items(posts) { post ->
	//                HazardPostCard(post)
	//            }
	//        }
	//    }
	//}
	//
	//@Composable
	//fun HazardPostCard(post: HazardResponse) {
	//
	//    val isHazard = post.hazard_label == 1
	//    val hazardLabel = if (isHazard) "⚠ HIGH RISK" else "🟢 SAFE"
	//    val hazardColor = if (isHazard) Color(0xFFEF4444) else Color(0xFF22C55E)
	//
	//    val (sentEmoji, sentText) = when (post.sentiment.lowercase()) {
	//        "fear", "panic" -> "😨" to "Fear"
	//        "positive", "relief", "calm", "good", "safe" -> "🙂" to "Positive"
	//        else -> "😐" to "Neutral"
	//    }
	//
	//    val keywordsText = post.keywords.joinToString(", ")
	//
	//    Card(
	//        modifier = Modifier.fillMaxWidth(),
	//        colors = CardDefaults.cardColors(Color(0xFF020617)),
	//        shape = RoundedCornerShape(12.dp),
	//        border = BorderStroke(1.dp, Color(0xFF374151))
	//    ) {
	//        Column(
	//            modifier = Modifier
	//                .fillMaxWidth()
	//                .padding(vertical = 10.dp, horizontal = 12.dp),
	//            verticalArrangement = Arrangement.spacedBy(4.dp)
	//        ) {
	//            Text("🌊 \"${post.text}\"", fontSize = 14.sp, fontWeight = FontWeight.Medium)
	//            Text(hazardLabel, fontSize = 13.sp, color = hazardColor)
	//            Text("$sentEmoji Sentiment: $sentText", fontSize = 13.sp)
	//            Text("🔑 Keywords: $keywordsText", fontSize = 13.sp, color = Color(0xFF9CA3AF))
	//        }
	//    }
	//}
	//
	//// ---------------------------------------------------------------------
	//// PROFILE SCREEN
	//// ---------------------------------------------------------------------
	//@Composable
	//fun ProfileScreen(username: String) {
	//    Column(
	//        modifier = Modifier
	//            .fillMaxSize()
	//            .padding(24.dp),
	//        verticalArrangement = Arrangement.spacedBy(16.dp)
	//    ) {
	//        Text("Name: $username", fontSize = 16.sp)
	//        Text(
	//            "Role: Hazard Monitoring Officer",
	//            fontSize = 14.sp,
	//            color = Color(0xFF9CA3AF)
	//        )
	//
	//        Spacer(Modifier.height(10.dp))
	//
	//        Spacer(Modifier.height(80.dp))
	//    }
	//}
	//
	//// ---------------------------------------------------------------------
	//// PREVIEW
	//// ---------------------------------------------------------------------
	//@Preview(showSystemUi = true, showBackground = true)
	//@Composable
	//fun PreviewApdaSetu() {
	//    MaterialTheme(colorScheme = darkColorScheme()) {
	//        ApdaSetuApp()
	//    }
	//}lid 4.0.0 to a stable version (e.g., 3.3.1)
	id("org.springframework.boot") version "3.3.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "org.incois"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Core Spring Boot Starters (Necessary for your application)
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web") // Includes MVC components

	// Minor cleanup: 'starter-webmvc' is included in 'starter-web' above, so we can remove it
	// implementation("org.springframework.boot:spring-boot-starter-webmvc")

	// ⭐ MySQL Connector
	implementation("com.mysql:mysql-connector-j")

	// ⭐ JWT Authentication Library (IMPORTANT)
	implementation("io.jsonwebtoken:jjwt-api:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

	// Lombok
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	developmentOnly("org.springframework.boot:spring-boot-devtools")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}