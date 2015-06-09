@RestController
class App {
  @RequestMapping("/")
  String home() {
    return "Hello World from Groovy !"
  }
}
