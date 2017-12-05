import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Observable, Observer} from 'rxjs';

@Injectable()
export class BookService {
  private books: Book[] = [];
  private sequencer: number = 1;
  private booksFromBackend: boolean = false;

  constructor(private http: Http) {
  }

  findOne(id: number): Book {
    const originalBook = this.findById(id);
    if (originalBook) {
      return Object.assign({}, originalBook);
    }
  }

  save(bookToSave: Book): void {
    console.log('Saving book');
    this.http.post('services/rest/book', bookToSave);
  }

  findAll(): Observable<Book[]> {
    return this.fetchBooksFromBackend();
  }

  private findById(id: number): Book {
    for (const book of this.books) {
      if (book.id === id) {
        return book;
      }
    }
  };

  private fetchBooksFromBackend(): Observable<Book[]> {
    if (!this.booksFromBackend) {
      return this.http.get('services/rest/books').map((response) => {
        const json: any = response.json();
        if (json) {
          json.forEach(((book: Book) => this.books.push(book)));
          this.sequencer = Math.max.apply(null, (this.books.map((book => book.id)))) + 1;
        }
        this.booksFromBackend = true;
        return this.books;
      });
    }

    return new Observable<Book[]>((observer: Observer<Book[]>) => {
      observer.next(this.books);
      observer.complete();
    });
  }
}

export interface Book {
   id?: number;
   author?: string;
   title?: string;
}
