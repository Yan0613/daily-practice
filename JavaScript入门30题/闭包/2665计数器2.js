var createCounter = function (init) {
    return {
      initVal: init,
      increment: function increment() {
        return ++init;
      },
      decrement: function increment() {
        return --init;
      },
      reset: function increment() {
        return (init = this.initVal);
      },
    };
  };
