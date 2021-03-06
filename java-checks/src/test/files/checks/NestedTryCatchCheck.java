class A {
  public void f() {
    try {
    } finally {
    }

    try {
      try {             // Compliant
      } finally {
      }
    } catch (Exception e) {
    }

    try {
    } catch (Exception e) {
      try {             // Compliant
      } catch (Exception e) {
      }
    }

    try {
    } catch (Exception e) {
      try {             // Compliant
      } finally {
      }
    }

    try {
    } catch (Exception e) {
      try {             // Compliant
      } catch (Exception e) {
      }
    } finally {
      try {             // Compliant
      } catch (Exception e) {
      }
    }

    try {
      try {             // Noncompliant {{Extract this nested try block into a separate method.}}
      } catch (Exception e) {
      }

      try {             // Noncompliant
      } catch (Exception e) {
        try {           // Noncompliant [[sc=9;ec=12;secondary=39]]

        } catch (Exception e) {
        }
      }
    } catch (Exception e) {
    }

    try (Resource r = new Resource()) {    // Compliant
      try (Resource r = new Resource()) {  // Compliant
        try {                              // Compliant
        } finally {
        }
      }
    }

    try {
      try {                                // Compliant
      } catch (Exception e) {
      }
    } finally {
    }

    try {
      try{ // Noncompliant
        try (Resource r = new Resource()){
        }
      }catch (Exception e){}
    } catch (Exception e) {}
  }
}
