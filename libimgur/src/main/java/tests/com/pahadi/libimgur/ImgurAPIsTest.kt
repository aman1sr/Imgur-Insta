package tests.com.pahadi.libimgur

import com.pahadi.libimgur.ImgurClient
import org.junit.Test
import org.junit.Assert.assertNotNull

class ImgurAPIsTest {
    val api = ImgurClient.api

@Test
fun `get tags working`(){
    val response = api.getTags().execute()
    assertNotNull(response.body())
}

    @Test
    fun `get gallery -hot working`(){
    val response = api.getGallery("hot").execute()
    assertNotNull(response.body())
}
    @Test
   fun `get gallery -top working`(){
    val response = api.getGallery("top").execute()
    assertNotNull(response.body())
}



}