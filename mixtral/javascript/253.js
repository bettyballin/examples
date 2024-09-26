import * as DOMPurify from 'dompurify';
import { fromEvent } from 'rxjs';
import { map } from 'rxjs/operators';

// ...

fromEvent(this.muInput.nativeElement, 'input').pipe(
  map((event: InputEvent) => {
    const cleanData = DOMPurify.sanitize(event.data);

    return this.saveToDatabase(cleanData)
      .catch((error) => console.error('Error saving to database', error));
  })
).subscribe();