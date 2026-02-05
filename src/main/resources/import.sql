INSERT INTO artist (id, name)
VALUES ('888fc2ba-2027-4a9b-a569-4a2527329bf2', 'Delain'),
       ('56c0b88d-30f8-48e9-a5ef-b136fd1adbb8', 'Nightwish'),
       ('39dcfaa1-0841-4575-9f34-e411f3e8a211', 'Indica');

INSERT INTO song (id, title, duration, artist_id)
VALUES ('14b183b4-a225-4957-aed8-d0af87b11f36', 'Stardust', (60 * 3 + 57), '888fc2ba-2027-4a9b-a569-4a2527329bf2'),
       ('3fbf0d43-04ee-46fd-8d70-d5879d032d10', 'April Rain', (60 * 4 + 37), '888fc2ba-2027-4a9b-a569-4a2527329bf2'),
       ('2d0b116c-42da-4be8-a1bf-bfb9f989fbd9', 'We Are the Others', (60 * 3 + 19),
        '888fc2ba-2027-4a9b-a569-4a2527329bf2'),
       ('5698ee39-c748-4025-bdd2-6e9488c7e0a5', 'Élan', (60 * 4 + 47), '56c0b88d-30f8-48e9-a5ef-b136fd1adbb8'),
       ('248be6d5-2b7b-48cf-97bc-de9ae1220add', 'Nemo', (60 * 4 + 34), '56c0b88d-30f8-48e9-a5ef-b136fd1adbb8'),
       ('e89b8fe7-614b-436f-9d87-75917bdbaa3f', 'Storytime', (60 * 5 + 22), '56c0b88d-30f8-48e9-a5ef-b136fd1adbb8'),
       ('8833dd72-eaf0-46ee-843c-c748122314d1', 'Elä', (60 * 3 + 25), '39dcfaa1-0841-4575-9f34-e411f3e8a211'),
       ('3fe27b13-8120-4c1a-bc71-9fef052e29d6', 'Pahinta tänään', (60 * 3 + 24),
        '39dcfaa1-0841-4575-9f34-e411f3e8a211'),
       ('0b54477e-6505-4913-b65d-a7836f311c1d', 'Askeleet', (60 * 4 + 4), '39dcfaa1-0841-4575-9f34-e411f3e8a211');

INSERT INTO playlist (id, name)
VALUES ('1302b043-e176-4faa-8f32-abd1bd03c616', 'English songs'),
       ('23bc843f-3920-469c-859e-da6488cffdbe', 'At least 4 minutes long songs');

INSERT INTO playlist_songs (playlist_id, song_id)
VALUES ('1302b043-e176-4faa-8f32-abd1bd03c616', '14b183b4-a225-4957-aed8-d0af87b11f36'),
       ('1302b043-e176-4faa-8f32-abd1bd03c616', '3fbf0d43-04ee-46fd-8d70-d5879d032d10'),
       ('1302b043-e176-4faa-8f32-abd1bd03c616', '2d0b116c-42da-4be8-a1bf-bfb9f989fbd9'),
       ('1302b043-e176-4faa-8f32-abd1bd03c616', '5698ee39-c748-4025-bdd2-6e9488c7e0a5'),
       ('1302b043-e176-4faa-8f32-abd1bd03c616', '248be6d5-2b7b-48cf-97bc-de9ae1220add'),
       ('1302b043-e176-4faa-8f32-abd1bd03c616', 'e89b8fe7-614b-436f-9d87-75917bdbaa3f'),
       ('23bc843f-3920-469c-859e-da6488cffdbe', '3fbf0d43-04ee-46fd-8d70-d5879d032d10'),
       ('23bc843f-3920-469c-859e-da6488cffdbe', '5698ee39-c748-4025-bdd2-6e9488c7e0a5'),
       ('23bc843f-3920-469c-859e-da6488cffdbe', '248be6d5-2b7b-48cf-97bc-de9ae1220add'),
       ('23bc843f-3920-469c-859e-da6488cffdbe', '0b54477e-6505-4913-b65d-a7836f311c1d'),
       ('23bc843f-3920-469c-859e-da6488cffdbe', 'e89b8fe7-614b-436f-9d87-75917bdbaa3f');
